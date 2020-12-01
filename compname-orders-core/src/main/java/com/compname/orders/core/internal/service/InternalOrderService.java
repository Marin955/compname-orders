package com.compname.orders.core.internal.service;

import com.compname.orders.api.message.request.account.CreateAccountRequest;
import com.compname.orders.api.message.request.account.SearchAccountRequest;
import com.compname.orders.api.message.request.account.UpdateAccountRequest;
import com.compname.orders.api.message.request.business.CreateBusinessRequest;
import com.compname.orders.api.message.request.business.SearchBusinessRequest;
import com.compname.orders.api.message.request.business.UpdateBusinessRequest;
import com.compname.orders.api.message.request.city.CreateCityRequest;
import com.compname.orders.api.message.request.city.SearchCityRequest;
import com.compname.orders.api.message.request.city.SearchExtendedCityRequest;
import com.compname.orders.api.message.request.city.UpdateCityRequest;
import com.compname.orders.api.message.request.custom.SearchTermByOfferAndTimeRequest;
import com.compname.orders.api.message.request.employee.CreateEmployeeRequest;
import com.compname.orders.api.message.request.employee.SearchEmployeeRequest;
import com.compname.orders.api.message.request.employee.UpdateEmployeeRequest;
import com.compname.orders.api.message.request.offer.CreateOfferRequest;
import com.compname.orders.api.message.request.offer.SearchOfferRequest;
import com.compname.orders.api.message.request.offer.UpdateOfferRequest;
import com.compname.orders.api.message.request.term.CreateTermRequest;
import com.compname.orders.api.message.request.term.SearchTermRequest;
import com.compname.orders.api.message.request.term.UpdateTermRequest;
import com.compname.orders.api.message.request.workhour.CreateWorkHourRequest;
import com.compname.orders.api.message.request.workhour.SearchWorkHourRequest;
import com.compname.orders.api.message.request.workhour.UpdateWorkHourRequest;
import com.compname.orders.api.model.account.Account;
import com.compname.orders.api.model.business.Address;
import com.compname.orders.api.model.business.Business;
import com.compname.orders.api.model.business.ContactInfo;
import com.compname.orders.api.model.business.Geolocation;
import com.compname.orders.api.model.city.City;
import com.compname.orders.api.model.city.ExtendedCity;
import com.compname.orders.api.model.employee.Employee;
import com.compname.orders.api.model.offer.Offer;
import com.compname.orders.api.model.term.Term;
import com.compname.orders.api.model.workhour.WorkHour;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.model.InternalAccount;
import com.compname.orders.core.internal.model.InternalBusiness;
import com.compname.orders.core.internal.model.InternalCity;
import com.compname.orders.core.internal.model.InternalEmployee;
import com.compname.orders.core.internal.model.InternalOffer;
import com.compname.orders.core.internal.model.InternalTerm;
import com.compname.orders.core.internal.model.InternalWorkHour;
import com.compname.orders.core.persistence.model.DbAccount;
import com.compname.orders.core.persistence.model.DbBusiness;
import com.compname.orders.core.persistence.model.DbCity;
import com.compname.orders.core.persistence.model.DbEmployee;
import com.compname.orders.core.persistence.model.DbOffer;
import com.compname.orders.core.persistence.model.DbTerm;
import com.compname.orders.core.persistence.model.DbWorkHour;
import com.compname.orders.core.persistence.repository.BusinessRepository;
import com.compname.orders.core.persistence.repository.CityRepository;
import com.compname.orders.core.persistence.repository.EmployeeRepository;
import com.compname.orders.core.persistence.repository.OfferRepository;
import com.compname.orders.core.persistence.repository.TermRepository;
import com.compname.orders.core.persistence.repository.AccountRepository;
import com.compname.orders.core.persistence.repository.WorkHourRepository;
import com.compname.orders.utility.OrdersServiceException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InternalOrderService {

    private static final Logger logger = LoggerFactory.getLogger(InternalOrderService.class);

    private final BusinessRepository businessRepo;
    private final CityRepository cityRepo;
    private final OfferRepository offerRepo;
    private final TermRepository termRepo;
    private final AccountRepository accountRepo;
    private final EmployeeRepository employeeRepo;
    private final WorkHourRepository workHourRepo;

    public List<Term> findByOfferAndTime(SearchTermByOfferAndTimeRequest request) {

        List<InternalEmployee> employees = getEmployeesByCityAndOffer(request);
        List<Term> resultTerms = new ArrayList<>();

        employees.forEach(employee -> {
            InternalOffer offer = employee.getOffers()
                    .stream()
                    .filter(internalOffer -> internalOffer.getName().equals(request.getOffer()))
                    .collect(Collectors.toList()).get(0);
            List<WorkHour> relevantWorkHours = findRelevantWorkHours(request.getFrom(), request.getTo(), employee.getWorkHours());
            if (relevantWorkHours.isEmpty()) return;

            relevantWorkHours.forEach(workHour -> {
                List<Term> relevantTerms = findRelevantTerms(workHour.getFrom(), workHour.getTo(), employee.getTerms());
                if (relevantTerms.isEmpty()) return;
                if (Duration.between(workHour.getFrom(), relevantTerms.get(0).getFrom())
                        .compareTo(offer.getDuration()) >= 0) {
                    resultTerms.add(new Term(
                            ZonedDateTime.now(),
                            offer.getId(),
                            0L,
                            employee.getId(),
                            workHour.getFrom(),
                            relevantTerms.get(0).getFrom()
                    ));
                }
                if (Duration.between(relevantTerms.get(relevantTerms.size()-1).getTo(), workHour.getTo())
                        .compareTo(offer.getDuration()) >= 0) {
                    resultTerms.add(new Term(
                            ZonedDateTime.now(),
                            offer.getId(),
                            0L,
                            employee.getId(),
                            relevantTerms.get(relevantTerms.size()-1).getTo(),
                            workHour.getTo()
                    ));
                }
                if (relevantTerms.size() == 1) return;
                for (int i = 0; i<relevantTerms.size()-1; i++) {
                    if (Duration.between(
                            relevantTerms.get(i).getTo(),
                            relevantTerms.get(i+1).getFrom())
                                .compareTo(offer.getDuration()) >= 0) {
                        resultTerms.add(new Term(
                                ZonedDateTime.now(),
                                offer.getId(),
                                0L,
                                employee.getId(),
                                relevantTerms.get(i).getTo(),
                                relevantTerms.get(i+1).getFrom()
                        ));
                    }
                }
            });
        });

        return resultTerms;
    }

    private List<WorkHour> findRelevantWorkHours(ZonedDateTime reqFrom, ZonedDateTime reqTo, List<InternalWorkHour> workHours) {
        List<WorkHour> relevantWorkHours = new ArrayList<>();

        for(InternalWorkHour workHour : workHours) {
            if (workHour.getFrom().isBefore(reqFrom) && workHour.getTo().isAfter(reqFrom) && workHour.getTo().isBefore(reqTo)) {
                WorkHour tmpWorkHour = workHour.toApi();
                tmpWorkHour.setFrom(reqFrom);
                relevantWorkHours.add(tmpWorkHour);
            }
            else if (workHour.getFrom().isAfter(reqFrom) && workHour.getTo().isBefore(reqTo)) {
                relevantWorkHours.add(workHour.toApi());
            }
            else if (workHour.getFrom().isAfter(reqFrom) && workHour.getFrom().isBefore(reqTo)) {
                WorkHour tmpWorkHour = workHour.toApi();
                tmpWorkHour.setTo(reqTo);
                relevantWorkHours.add(tmpWorkHour);
                break;
            }
        }
         return relevantWorkHours;
    }

    private List<Term> findRelevantTerms(ZonedDateTime whFrom, ZonedDateTime whTo, List<InternalTerm> terms) {
        List<Term> relevantTerms = new ArrayList<>();

        for(InternalTerm term : terms) {
            if(term.getFrom().isAfter(whFrom) && term.getTo().isBefore(whTo)) relevantTerms.add(term.toApi());
            if(term.getFrom().isAfter(whTo)) break;
        }

        return relevantTerms;
    }

    private List<InternalEmployee> getEmployeesByCityAndOffer(SearchTermByOfferAndTimeRequest request) {
        return employeeRepo.findAll(
                (Specification<DbEmployee>)
                        (root, criteriaQuery, criteriaBuilder) -> {
                            List<Predicate> predicates = new ArrayList<>();

                            if (Objects.nonNull(request.getCityId())) {
                                predicates.add(
                                        criteriaBuilder.equal(
                                                root.get(DbEmployee.DbEmployeeMapping.BUSINESS.getField())
                                                        .get(DbBusiness.DbBusinessMapping.CITY_ID.getField()),
                                                request.getCityId()));
                            }
                            predicates.add(
                                    criteriaBuilder.equal(
                                            root.join(DbEmployee.DbEmployeeMapping.OFFERS.getField())
                                                    .get(DbOffer.DbOfferMapping.NAME.getField()),
                                            request.getOffer()
                                    )
                            );
                            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                        }
        ).stream().map(this::toInternal).collect(Collectors.toList());
    }

    public InternalBusiness getBusinessBy(Long id) {
        Optional<DbBusiness> result = businessRepo.findById(id);
        return result.map(this::toInternal).orElse(null);
    }

    public InternalBusiness create(CreateBusinessRequest request)
    {
        DbBusiness dbBusiness = new DbBusiness();

        dbBusiness.setOib(request.getOib());
        dbBusiness.setName(request.getName());
        dbBusiness.setCreated(request.getCreated());
        dbBusiness.setCreatedBy(request.getCreatedBy());
        dbBusiness.setCity(cityRepo.getOne(request.getCityId()));
        dbBusiness.setAddress(request.getAddress());
        dbBusiness.setLongitude(request.getGeolocation().getLongitude());
        dbBusiness.setLatitude(request.getGeolocation().getLatitude());
        dbBusiness.setPhone(request.getContactInfo().getPhone());
        dbBusiness.setMail(request.getContactInfo().getMail());
        dbBusiness.setWebsite(request.getContactInfo().getWebsite());
        dbBusiness.setRating(5.0f);
        dbBusiness.setMinInterval(request.getMinInterval());

        return toInternal(businessRepo.save(dbBusiness));
    }

    public List<InternalBusiness> search(SearchBusinessRequest request)
    {
        return businessRepo
                .findAll(
                        (Specification<DbBusiness>)
                                (root, criteriaQuery, criteriaBuilder) -> {
                                    List<Predicate> predicates = new ArrayList<>();

                                    if (Objects.nonNull(request.getName())) {
                                        predicates.add(
                                                criteriaBuilder.equal(
                                                        root.get(DbBusiness.DbBusinessMapping.NAME.getField()),
                                                        request.getName()));
                                    }
                                    if (Objects.nonNull(request.getOib())) {
                                        predicates.add(
                                                criteriaBuilder.equal(
                                                        root.get(DbBusiness.DbBusinessMapping.OIB.getField()),
                                                        request.getOib()));
                                    }
                                    if (Objects.nonNull(request.getCity())) {
                                        predicates.add(
                                                criteriaBuilder.equal(
                                                        root.get(DbBusiness.DbBusinessMapping.CITY_ID.getField())
                                                                .get(DbCity.DbCityMapping.ID.getField()),
                                                        cityRepo.findByName(request.getCity()).getId()));
                                    }
                                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                                },
                        PageRequest.of(request.getPageNumber(), request.getPageSize()))
                .stream()
                .map(this::toInternal)
                .collect(Collectors.toList());
    }

    public InternalOffer getOfferBy(Long id) {
        Optional<DbOffer> result = offerRepo.findById(id);
        return result.map(this::toInternal).orElse(null);
    }

    public InternalOffer create(CreateOfferRequest request) {
        DbOffer dbOffer = new DbOffer();

        dbOffer.setName(request.getName());
        dbOffer.setBusiness(businessRepo.getOne(request.getBusinessId()));
        dbOffer.setCreated(request.getCreated());
        dbOffer.setCreatedBy(request.getCreatedBy());
        dbOffer.setDuration(request.getDuration());
        dbOffer.setPrice(request.getPrice());

        return toInternal(offerRepo.save(dbOffer));
    }

    public Set<InternalOffer> search(SearchOfferRequest request)
    {
    return offerRepo
        .findAll(
            ((Specification<DbOffer>)
                (root, criteriaQuery, criteriaBuilder) -> {
                  List<Predicate> predicates = new ArrayList<>();

                  if (Objects.nonNull(request.getBusinessId())) {
                    predicates.add(
                        criteriaBuilder.equal(
                            root.get(DbOffer.DbOfferMapping.BUSINESS.getField())
                                .get(DbBusiness.DbBusinessMapping.ID.getField()),
                            request.getBusinessId()));
                  }
                  if (Objects.nonNull(request.getName())) {
                    predicates.add(
                        criteriaBuilder.equal(
                            root.get(DbOffer.DbOfferMapping.NAME.getField()), request.getName()));
                  }
                  return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                }),
            PageRequest.of(request.getPageNumber(), request.getPageSize()))
        .stream()
        .map(this::toInternal)
        .collect(Collectors.toSet());
    }

    public InternalCity getCityBy(Long id) {
        Optional<DbCity> result = cityRepo.findById(id);
        return result.map(this::toInternal).orElse(null);
    }

    public InternalCity getCityByName(String name) {
        return toInternal(cityRepo.findByName(name));
    }

    public InternalCity create(CreateCityRequest request) {
        DbCity dbCity = new DbCity();

        dbCity.setName(request.getName());
        dbCity.setPostalCode(request.getPostalCode());

        return toInternal(cityRepo.save(dbCity));
    }

    public List<InternalCity> search(SearchExtendedCityRequest request) {
        return commonSearch(request.getName(), request.getPostalCode(), request.getPageNumber(), request.getPageSize());
    }

    public List<InternalCity> search(SearchCityRequest request) {
        return commonSearch(request.getName(), request.getPostalCode(), request.getPageNumber(), request.getPageSize());
    }

    private List<InternalCity> commonSearch(String name, Integer postalCode, Integer pageNumber, Integer pageSize) {
        return cityRepo
                .findAll(
                        ((Specification<DbCity>)
                                (root, criteriaQuery, criteriaBuilder) -> {
                                    List<Predicate> predicates = new ArrayList<>();

                                    if (Objects.nonNull(name)) {
                                        predicates.add(
                                                criteriaBuilder.equal(
                                                        root.get(DbCity.DbCityMapping.NAME.getField()), name));
                                    }
                                    if (Objects.nonNull(postalCode)) {
                                        predicates.add(
                                                criteriaBuilder.equal(
                                                        root.get(DbCity.DbCityMapping.POSTAL_CODE.getField()),
                                                        postalCode));
                                    }
                                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                                }),
                        PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(this::toInternal)
                .collect(Collectors.toList());
    }

    public InternalAccount getAccountBy(Long id) {
        Optional<DbAccount> result = accountRepo.findById(id);
        return result.map(this::toInternal).orElse(null);
    }

    public InternalAccount create(CreateAccountRequest request) {
        DbAccount dbAccount = new DbAccount();

        dbAccount.setFirstName(request.getFirstName());
        dbAccount.setLastName(request.getLastName());
        dbAccount.setCreated(request.getCreated());
        dbAccount.setMail(request.getMail());
        dbAccount.setPassword(request.getPassword());
        dbAccount.setPhone(request.getPhone());
        dbAccount.setStrikes(request.getStrikes());

        return toInternal(accountRepo.save(dbAccount));
    }

    public List<InternalAccount> search(SearchAccountRequest request) {
    return accountRepo
        .findAll(
            ((Specification<DbAccount>)
                (root, criteriaQuery, criteriaBuilder) -> {
                  List<Predicate> predicates = new ArrayList<>();

                  if (Objects.nonNull(request.getFirstName())) {
                    predicates.add(
                        criteriaBuilder.equal(
                            root.get(DbAccount.DbAccountMapping.FIRST_NAME.getField()),
                            request.getFirstName()));
                  }
                  if (Objects.nonNull(request.getLastName())) {
                    predicates.add(
                        criteriaBuilder.equal(
                            root.get(DbAccount.DbAccountMapping.LAST_NAME.getField()),
                            request.getLastName()));
                  }
                  if (Objects.nonNull(request.getPhone())) {
                    predicates.add(
                        criteriaBuilder.equal(
                            root.get(DbAccount.DbAccountMapping.PHONE.getField()),
                            request.getPhone()));
                  }
                  if (Objects.nonNull(request.getStrikes())) {
                    predicates.add(
                        criteriaBuilder.equal(
                            root.get(DbAccount.DbAccountMapping.STRIKES.getField()),
                            request.getStrikes()));
                  }
                  return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                }),
            PageRequest.of(request.getPageNumber(), request.getPageSize()))
        .stream()
        .map(this::toInternal)
        .collect(Collectors.toList());
    }

    public InternalTerm getTermBy(Long id) {
        Optional<DbTerm> result = termRepo.findById(id);
        return result.map(this::toInternal).orElse(null);
    }

    public InternalTerm create(CreateTermRequest request) {
        DbTerm dbTerm = new DbTerm();

        dbTerm.setCreated(request.getCreated());
        dbTerm.setFrom(request.getFrom());
        dbTerm.setTo(request.getTo());
        dbTerm.setAccount(accountRepo.getOne(request.getAccountId()));
        dbTerm.setOffer(offerRepo.getOne(request.getOfferId()));
        dbTerm.setEmployee(employeeRepo.getOne(request.getEmployeeId()));

        return toInternal(termRepo.save(dbTerm));
    }

    public List<InternalTerm> search(SearchTermRequest request) {
    return termRepo
        .findAll(
            ((Specification<DbTerm>)
                (root, criteriaQuery, criteriaBuilder) -> {
                  List<Predicate> predicates = new ArrayList<>();

                    if (Objects.nonNull(request.getAccountId())) {
                        predicates.add(
                                criteriaBuilder.equal(
                                        root.get(DbTerm.DbTermMapping.ACCOUNT_ID.getField())
                                                .get(DbAccount.DbAccountMapping.ID.getField()),
                                        request.getAccountId()));
                    }
                    if (Objects.nonNull(request.getOfferId())) {
                        predicates.add(
                                criteriaBuilder.equal(
                                        root.get(DbTerm.DbTermMapping.OFFER_ID.getField())
                                                .get(DbOffer.DbOfferMapping.ID.getField()),
                                        request.getOfferId()));
                    }
                    if (Objects.nonNull(request.getEmployeeId())) {
                        predicates.add(
                                criteriaBuilder.equal(
                                        root.get(DbTerm.DbTermMapping.EMPLOYEE_ID.getField())
                                                .get(DbEmployee.DbEmployeeMapping.ID.getField()),
                                        request.getEmployeeId()));
                    }
                    if (Objects.nonNull(request.getFrom())) {
                        predicates.add(
                                criteriaBuilder.greaterThanOrEqualTo(
                                        root.get(DbTerm.DbTermMapping.FROM.getField()), request.getFrom()));
                    }
                    if (Objects.nonNull(request.getTo())) {
                        predicates.add(
                                criteriaBuilder.lessThanOrEqualTo(
                                        root.get(DbTerm.DbTermMapping.TO.getField()), request.getTo()));
                    }
                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                }),
                PageRequest.of(request.getPageNumber(), request.getPageSize()))
            .stream()
            .map(this::toInternal)
            .collect(Collectors.toList());
    }

    public InternalEmployee getEmployeeBy(Long id) {
        Optional<DbEmployee> result = employeeRepo.findById(id);
        return result.map(this::toInternal).orElse(null);
    }

    public InternalEmployee create(CreateEmployeeRequest request) {
        DbEmployee dbEmployee = new DbEmployee();

        dbEmployee.setName(request.getName());
        dbEmployee.setCreated(request.getCreated());
        dbEmployee.setCreatedBy(request.getCreatedBy());
        dbEmployee.setTitle(request.getTitle());
        dbEmployee.setBusiness(businessRepo.getOne(request.getBusinessId()));
        dbEmployee.setOffers(request.getOfferIds().stream().map(offerRepo::getOne).collect(Collectors.toSet()));

        return toInternal(employeeRepo.save(dbEmployee));
    }

    public List<InternalEmployee> search(SearchEmployeeRequest request) {
        return employeeRepo
                .findAll(
                        ((Specification<DbEmployee>)
                                (root, criteriaQuery, criteriaBuilder) -> {
                                    List<Predicate> predicates = new ArrayList<>();

                                    if (Objects.nonNull(request.getName())) {
                                        predicates.add(
                                                criteriaBuilder.equal(
                                                        root.get(DbEmployee.DbEmployeeMapping.NAME.getField()),
                                                        request.getName()));
                                    }
                                    if (Objects.nonNull(request.getBusinessId())) {
                                        predicates.add(
                                                criteriaBuilder.equal(
                                                        root.get(DbEmployee.DbEmployeeMapping.BUSINESS.getField())
                                                                .get(DbBusiness.DbBusinessMapping.ID.getField()),
                                                        request.getBusinessId()));
                                    }
                                    if (Objects.nonNull(request.getOfferId())) {
                                        predicates.add(
                                                criteriaBuilder.greaterThanOrEqualTo(
                                                        root.get(DbEmployee.DbEmployeeMapping.OFFERS.getField())
                                                        .get(DbEmployee.DbEmployeeMapping.OFFERS.getColumn()),
                                                        request.getOfferId()));
                                    }
                                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                                }),
                        PageRequest.of(request.getPageNumber(), request.getPageSize()))
                .stream()
                .map(this::toInternal)
                .collect(Collectors.toList());
    }

    public InternalWorkHour getWorkHourBy(Long id) {
        Optional<DbWorkHour> result = workHourRepo.findById(id);
        return result.map(this::toInternal).orElse(null);
    }

    public InternalWorkHour create(CreateWorkHourRequest request) {
        DbWorkHour dbWorkHour = new DbWorkHour();

        dbWorkHour.setEmployee(employeeRepo.getOne(request.getEmployeeId()));
        dbWorkHour.setFrom(request.getFrom());
        dbWorkHour.setTo(request.getTo());

        return toInternal(workHourRepo.save(dbWorkHour));
    }

    public List<InternalWorkHour> search(SearchWorkHourRequest request) {
        return workHourRepo
                .findAll(
                        ((Specification<DbWorkHour>)
                                (root, criteriaQuery, criteriaBuilder) -> {
                                    List<Predicate> predicates = new ArrayList<>();

                                    if (Objects.nonNull(request.getEmployeeId())) {
                                        predicates.add(
                                                criteriaBuilder.equal(
                                                        root.get(DbWorkHour.DbWorkHourMapping.EMPLOYEE.getField())
                                                        .get(DbEmployee.DbEmployeeMapping.ID.getField()),
                                                        request.getEmployeeId()));
                                    }
                                    if (Objects.nonNull(request.getFrom())) {
                                        predicates.add(
                                                criteriaBuilder.greaterThanOrEqualTo(
                                                        root.get(DbWorkHour.DbWorkHourMapping.FROM.getField()),
                                                        request.getFrom()));
                                    }
                                    if (Objects.nonNull(request.getTo())) {
                                        predicates.add(
                                                criteriaBuilder.lessThanOrEqualTo(
                                                        root.get(DbWorkHour.DbWorkHourMapping.TO.getField()),
                                                        request.getTo()));
                                    }
                                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                                }),
                        PageRequest.of(request.getPageNumber(), request.getPageSize()))
                .stream()
                .map(this::toInternal)
                .collect(Collectors.toList());
    }

    public InternalBusiness toInternal(DbBusiness dbBusiness) {
        return new InternalBusiness() {

            private final AtomicBoolean isDeleted = new AtomicBoolean(false);

            @Override
            public Long getId() {
                return dbBusiness.getId();
            }

            @Override
            public String getName() {
                return dbBusiness.getName();
            }

            @Override
            public ZonedDateTime getCreated() {
                return dbBusiness.getCreated();
            }

            @Override
            public String getCreatedBy() {
                return dbBusiness.getCreatedBy();
            }

            @Override
            public Long getOib() {
                return dbBusiness.getOib();
            }

            @Override
            public Address getAddress() {
                return new Address(
                        dbBusiness.getCity().getName(),
                        dbBusiness.getCity().getPostalCode(),
                        dbBusiness.getAddress());
            }

            @Override
            public ContactInfo getContactInfo() {
                return new ContactInfo(
                        dbBusiness.getPhone(), dbBusiness.getMail(), dbBusiness.getWebsite());
            }

            @Override
            public Geolocation getGeolocation() {
                return new Geolocation(dbBusiness.getLongitude(), dbBusiness.getLatitude());
            }

            @Override
            public String getMinInterval() {
                return dbBusiness.getMinInterval();
            }

            @Override
            public Float getRating() {
                return dbBusiness.getRating();
            }

            @Override
            public Set<InternalOffer> getOffers() {
                return dbBusiness.getOffers().stream()
                        .map(InternalOrderService.this::toInternal)
                        .collect(Collectors.toSet());
            }

            @Override
            public List<InternalEmployee> getEmployees() {
                return dbBusiness.getEmployees().stream()
                        .map(InternalOrderService.this::toInternal)
                        .collect(Collectors.toList());
            }

            @Override
            public Business toApi() {
                return new Business(
                        getId(),
                        getName(),
                        getCreated(),
                        getCreatedBy(),
                        getOib(),
                        getAddress(),
                        getContactInfo(),
                        getGeolocation(),
                        getRating(),
                        getMinInterval(),
                        getOffers().stream().map(ApiConvertible::toApi).collect(Collectors.toList()),
                        getEmployees().stream().map(ApiConvertible::toApi).collect(Collectors.toList())
                );
            }

            /** {@inheritDoc} */
            @Override
            public InternalBusiness delete() {
                defendDeleted();
                businessRepo.delete(dbBusiness);
                isDeleted.set(true);
                return this;
            }

            /** Defends an already deleted entity.<br> */
            private void defendDeleted() {
                if (isDeleted.get()) {
                    throw OrdersServiceException.validationError(
                            "DB Business entity already deleted [business=%s]", dbBusiness);
                }
            }

            @Override
            public InternalBusiness update(UpdateBusinessRequest request) {
                dbBusiness.setAddress(request.getAddress());
                dbBusiness.setMail(request.getMail());
                dbBusiness.setCity(cityRepo.getOne(request.getCityId()));
                dbBusiness.setLatitude(request.getLatitude());
                dbBusiness.setLongitude(request.getLongitude());
                dbBusiness.setMinInterval(request.getMinInterval());
                dbBusiness.setOib(request.getOib());
                dbBusiness.setName(request.getName());
                dbBusiness.setPhone(request.getPhone());
                dbBusiness.setRating(request.getRating());
                dbBusiness.setWebsite(request.getWebsite());

                return toInternal(businessRepo.save(dbBusiness));
            }
        };
    }

    public InternalOffer toInternal(DbOffer dbOffer) {
        return new InternalOffer() {

            private final AtomicBoolean isDeleted = new AtomicBoolean(false);

            @Override
            public Long getId() {
                return dbOffer.getId();
            }

            @Override
            public String getName() {
                return dbOffer.getName();
            }

            @Override
            public ZonedDateTime getCreated() {
                return dbOffer.getCreated();
            }

            @Override
            public String getCreatedBy() {
                return dbOffer.getCreatedBy();
            }

            @Override
            public Long getBusinessId() {
                return dbOffer.getBusiness().getId();
            }

            @Override
            public Float getPrice() {
                return dbOffer.getPrice();
            }

            @Override
            public Duration getDuration() {
                return Duration.parse(dbOffer.getDuration());
            }

            @Override
            public List<InternalTerm> getTerms() {
                return dbOffer.getTerms().stream()
                        .map(InternalOrderService.this::toInternal)
                        .collect(Collectors.toList());
            }

            @Override
            public Offer toApi() {
                return new Offer(
                        getId(),
                        getName(),
                        getCreated(),
                        getCreatedBy(),
                        getBusinessId(),
                        getPrice(),
                        getDuration(),
                        getTerms().stream().map(ApiConvertible::toApi).collect(Collectors.toList())
                );
            }

            /** {@inheritDoc} */
            @Override
            public InternalOffer delete() {
                defendDeleted();
                offerRepo.delete(dbOffer);
                isDeleted.set(true);
                return this;
            }

            /** Defends an already deleted entity.<br> */
            private void defendDeleted() {
                if (isDeleted.get()) {
                    throw OrdersServiceException.validationError(
                            "DB Offer entity already deleted [offer=%s]", dbOffer);
                }
            }

            @Override
            public InternalOffer update(UpdateOfferRequest request) {
                dbOffer.setName(request.getName());
                dbOffer.setPrice(request.getPrice());
                dbOffer.setDuration(request.getDuration());

                return toInternal(offerRepo.save(dbOffer));
            }
        };
    }

    public InternalCity toInternal(DbCity dbCity) {
        return new InternalCity() {

            private final AtomicBoolean isDeleted = new AtomicBoolean(false);

            @Override
            public Long getId() {
                return dbCity.getId();
            }

            @Override
            public String getName() {
                return dbCity.getName();
            }

            @Override
            public Integer getPostalCode() {
                return dbCity.getPostalCode();
            }

            @Override
            public List<InternalBusiness> getBusinesses() {
                return dbCity.getBusinesses().stream()
                        .map(InternalOrderService.this::toInternal)
                        .collect(Collectors.toList());
            }

            @Override
            public City toApi() {
                return new City(
                        getId(),
                        getName(),
                        getPostalCode()
                );
            }

            public ExtendedCity toExtendedApi() {
                return new ExtendedCity(
                        getId(),
                        getName(),
                        getPostalCode(),
                        getBusinesses().stream().map(ApiConvertible::toApi).collect(Collectors.toList())
                );
            }

            /** {@inheritDoc} */
            @Override
            public InternalCity delete() {
                defendDeleted();
                cityRepo.delete(dbCity);
                isDeleted.set(true);
                return this;
            }

            /** Defends an already deleted entity.<br> */
            private void defendDeleted() {
                if (isDeleted.get()) {
                    throw OrdersServiceException.validationError(
                            "DB City entity already deleted [city=%s]", dbCity);
                }
            }

            @Override
            public InternalCity update(UpdateCityRequest request) {

                dbCity.setName(request.getName());
                dbCity.setPostalCode(request.getPostalCode());

                return toInternal(cityRepo.save(dbCity));
            }
        };
    }

    public InternalAccount toInternal(DbAccount dbAccount) {
        return new InternalAccount() {
            private final AtomicBoolean isDeleted = new AtomicBoolean(false);
            @Override
            public Long getId() {
                return dbAccount.getId();
            }

            @Override
            public ZonedDateTime getCreated() {
                return dbAccount.getCreated();
            }

            @Override
            public String getFirstName() {
                return dbAccount.getFirstName();
            }

            @Override
            public String getLastName() {
                return dbAccount.getLastName();
            }

            @Override
            public String getMail() {
                return dbAccount.getMail();
            }

            @Override
            public String getPassword() {
                return dbAccount.getPassword();
            }

            @Override
            public String getPhone() {
                return dbAccount.getPhone();
            }

            @Override
            public Integer getStrikes() {
                return dbAccount.getStrikes();
            }

            @Override
            public List<InternalTerm> getTerms() {
                return dbAccount.getTerms().stream()
                        .map(InternalOrderService.this::toInternal)
                        .collect(Collectors.toList());
            }

            @Override
            public Account toApi() {
                return new Account(
                        getId(),
                        getCreated(),
                        getFirstName(),
                        getLastName(),
                        getMail(),
                        getPassword(),
                        getPhone(),
                        getStrikes(),
                        getTerms().stream().map(ApiConvertible::toApi).collect(Collectors.toList())
                );
            }

            /** {@inheritDoc} */
            @Override
            public InternalAccount delete() {
                defendDeleted();
                accountRepo.delete(dbAccount);
                isDeleted.set(true);
                return this;
            }

            /** Defends an already deleted entity.<br> */
            private void defendDeleted() {
                if (isDeleted.get()) {
                    throw OrdersServiceException.validationError(
                            "DB Account entity already deleted [account=%s]", dbAccount);
                }
            }

            @Override
            public InternalAccount update(UpdateAccountRequest request) {
                dbAccount.setFirstName(request.getFirstName());
                dbAccount.setLastName(request.getLastName());
                dbAccount.setPassword(request.getPassword());
                dbAccount.setPhone(request.getPhone());
                dbAccount.setMail(request.getMail());
                dbAccount.setStrikes(request.getStrikes());

                return toInternal(accountRepo.save(dbAccount));
            }
        };
    }

    public InternalTerm toInternal(DbTerm dbTerm) {
        return new InternalTerm() {

            private final AtomicBoolean isDeleted = new AtomicBoolean(false);

            @Override
            public Long getId() {
                return dbTerm.getId();
            }

            @Override
            public ZonedDateTime getCreated() { return dbTerm.getCreated(); }

            @Override
            public Long getOfferId() {
                return dbTerm.getOffer().getId();
            }

            @Override
            public Long getAccountId() {
                return dbTerm.getAccount().getId();
            }

            @Override
            public Long getEmployeeId() { return dbTerm.getEmployee().getId(); }

            @Override
            public ZonedDateTime getFrom() {
                return dbTerm.getFrom();
            }

            @Override
            public ZonedDateTime getTo() {
                return dbTerm.getTo();
            }

            @Override
            public Term toApi() {
                return new Term(
                        getId(),
                        getCreated(),
                        getOfferId(),
                        getAccountId(),
                        getEmployeeId(),
                        getFrom(),
                        getTo()
                );
            }

            /** {@inheritDoc} */
            @Override
            public InternalTerm delete() {
                defendDeleted();
                termRepo.delete(dbTerm);
                isDeleted.set(true);
                return this;
            }

            /** Defends an already deleted entity.<br> */
            private void defendDeleted() {
                if (isDeleted.get()) {
                    throw OrdersServiceException.validationError(
                            "DB Term entity already deleted [term=%s]", dbTerm);
                }
            }

            @Override
            public InternalTerm update(UpdateTermRequest request) {
                dbTerm.setFrom(request.getFrom());
                dbTerm.setTo(request.getTo());

                return toInternal(termRepo.save(dbTerm));
            }
        };
    }

    public InternalEmployee toInternal(DbEmployee dbEmployee) {
        return new InternalEmployee() {

            private final AtomicBoolean isDeleted = new AtomicBoolean(false);

            @Override
            public Long getId() { return dbEmployee.getId(); }

            @Override
            public String getName() { return dbEmployee.getName(); }

            @Override
            public ZonedDateTime getCreated() { return dbEmployee.getCreated(); }

            @Override
            public String getCreatedBy() { return dbEmployee.getCreatedBy(); }

            @Override
            public String getTitle() { return dbEmployee.getTitle(); }

            @Override
            public Set<InternalOffer> getOffers() {
                return dbEmployee.getOffers()
                        .stream()
                        .map(InternalOrderService.this::toInternal)
                        .collect(Collectors.toSet());
            }

            @Override
            public List<InternalWorkHour> getWorkHours() {
                return dbEmployee.getWorkHours()
                        .stream()
                        .map(InternalOrderService.this::toInternal)
                        .collect(Collectors.toList());
            }

            @Override
            public List<InternalTerm> getTerms() {
                return dbEmployee.getTerms()
                        .stream()
                        .map(InternalOrderService.this::toInternal)
                        .collect(Collectors.toList());
            }

            @Override
            public Long getBusinessId() { return dbEmployee.getBusiness().getId(); }

            @Override
            public Employee toApi() {
                return new Employee(
                        getId(),
                        getName(),
                        getCreated(),
                        getCreatedBy(),
                        getTitle(),
                        getBusinessId(),
                        getOffers().stream().map(ApiConvertible::toApi).collect(Collectors.toSet()),
                        getWorkHours().stream().map(ApiConvertible::toApi).collect(Collectors.toList()),
                        getTerms().stream().map(ApiConvertible::toApi).collect(Collectors.toSet())
                );
            }

            /** {@inheritDoc} */
            @Override
            public InternalEmployee delete() {
                defendDeleted();
                employeeRepo.delete(dbEmployee);
                isDeleted.set(true);
                return this;
            }

            /** Defends an already deleted entity.<br> */
            private void defendDeleted() {
                if (isDeleted.get()) {
                    throw OrdersServiceException.validationError(
                            "DB Employee entity already deleted [employee=%s]", dbEmployee);
                }
            }

            @Override
            public InternalEmployee update(UpdateEmployeeRequest request) {
                dbEmployee.setName(request.getName());
                dbEmployee.setTitle(request.getTitle());
                dbEmployee.setOffers(request.getOfferIds()
                        .stream()
                        .map(offerRepo::getOne)
                        .collect(Collectors.toSet()));

                return toInternal(employeeRepo.save(dbEmployee));
            }
        };
    }

    public InternalWorkHour toInternal(DbWorkHour dbWorkHour) {
        return new InternalWorkHour() {

            private final AtomicBoolean isDeleted = new AtomicBoolean(false);

            @Override
            public Long getId() {
                return dbWorkHour.getId();
            }

            @Override
            public Long getEmployeeId() {
                return dbWorkHour.getId();
            }

            @Override
            public ZonedDateTime getFrom() {
                return dbWorkHour.getFrom();
            }

            @Override
            public ZonedDateTime getTo() {
                return dbWorkHour.getTo();
            }

            @Override
            public WorkHour toApi() {
                return new WorkHour(
                        getId(),
                        getEmployeeId(),
                        getFrom(),
                        getTo()
                );
            }

            @Override
            public InternalWorkHour update(UpdateWorkHourRequest request) {
                dbWorkHour.setFrom(request.getFrom());
                dbWorkHour.setTo(request.getTo());

                return toInternal(workHourRepo.save(dbWorkHour));
            }

            /** {@inheritDoc} */
            @Override
            public InternalWorkHour delete() {
                defendDeleted();
                workHourRepo.delete(dbWorkHour);
                isDeleted.set(true);
                return this;
            }

            /** Defends an already deleted entity.<br> */
            private void defendDeleted() {
                if (isDeleted.get()) {
                    throw OrdersServiceException.validationError(
                            "DB WorkHour entity already deleted [employee=%s]", dbWorkHour);
                }
            }
        };
    }
}
