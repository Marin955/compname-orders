package com.compname.orders.core.internal.service;

import com.compname.orders.api.message.request.account.CreateAccountRequest;
import com.compname.orders.api.message.request.account.SearchAccountRequest;
import com.compname.orders.api.message.request.account.UpdateAccountRequest;
import com.compname.orders.api.message.request.business.CreateBusinessRequest;
import com.compname.orders.api.message.request.business.SearchBusinessRequest;
import com.compname.orders.api.message.request.business.UpdateBusinessRequest;
import com.compname.orders.api.message.request.city.CreateCityRequest;
import com.compname.orders.api.message.request.city.SearchCityRequest;
import com.compname.orders.api.message.request.city.UpdateCityRequest;
import com.compname.orders.api.message.request.offer.CreateOfferRequest;
import com.compname.orders.api.message.request.offer.SearchOfferRequest;
import com.compname.orders.api.message.request.offer.UpdateOfferRequest;
import com.compname.orders.api.message.request.term.CreateTermRequest;
import com.compname.orders.api.message.request.term.SearchTermRequest;
import com.compname.orders.api.message.request.term.UpdateTermRequest;
import com.compname.orders.api.model.account.Account;
import com.compname.orders.api.model.business.Address;
import com.compname.orders.api.model.business.Business;
import com.compname.orders.api.model.business.ContactInfo;
import com.compname.orders.api.model.business.Geolocation;
import com.compname.orders.api.model.city.City;
import com.compname.orders.api.model.offer.Offer;
import com.compname.orders.api.model.term.Term;
import com.compname.orders.core.internal.model.InternalAccount;
import com.compname.orders.core.internal.model.InternalBusiness;
import com.compname.orders.core.internal.model.InternalCity;
import com.compname.orders.core.internal.model.InternalOffer;
import com.compname.orders.core.internal.model.InternalTerm;
import com.compname.orders.core.persistence.model.DbAccount;
import com.compname.orders.core.persistence.model.DbBusiness;
import com.compname.orders.core.persistence.model.DbCity;
import com.compname.orders.core.persistence.model.DbOffer;
import com.compname.orders.core.persistence.model.DbTerm;
import com.compname.orders.core.persistence.repository.BusinessRepository;
import com.compname.orders.core.persistence.repository.CityRepository;
import com.compname.orders.core.persistence.repository.OfferRepository;
import com.compname.orders.core.persistence.repository.TermRepository;
import com.compname.orders.core.persistence.repository.AccountRepository;
import com.compname.orders.utility.OrdersServiceException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
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
        dbBusiness.setCity(cityRepo.findByName(request.getAddress().getCity()));
        dbBusiness.setAddress(request.getAddress().getAddress());
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
                            root.get(DbBusiness.DbBusinessMapping.NAME.getColumn()),
                            request.getName()));
                  }
                  if (Objects.nonNull(request.getOib())) {
                    predicates.add(
                        criteriaBuilder.equal(
                            root.get(DbBusiness.DbBusinessMapping.OIB.getColumn()),
                            request.getOib()));
                  }
                  if (Objects.nonNull(request.getCity())) {
                    predicates.add(
                        criteriaBuilder.equal(
                            root.get(DbBusiness.DbBusinessMapping.CITY_ID.getColumn()),
                            request.getCity()));
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

    public List<InternalOffer> search(SearchOfferRequest request) {
        return null;
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

    public List<InternalCity> search(SearchCityRequest request) {
        return null;
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
        return null;
    }

    public InternalTerm getTermBy(Long id) {
        Optional<DbTerm> result = termRepo.findById(id);
        return result.map(this::toInternal).orElse(null);
    }

    public InternalTerm create(CreateTermRequest request) {
        DbTerm dbTerm = new DbTerm();

        dbTerm.setFrom(request.getFrom());
        dbTerm.setTo(request.getTo());
        dbTerm.setAccount(accountRepo.getOne(request.getAccountId()));
        dbTerm.setOffer(offerRepo.getOne(request.getOfferId()));

        return toInternal(termRepo.save(dbTerm));
    }

    public List<InternalTerm> search(SearchTermRequest request) {
        return null;
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
                        getMinInterval());
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
            public String getDuration() {
                return dbOffer.getDuration();
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
                        getDuration()
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
            public City toApi() {
                return new City(
                        dbCity.getId(),
                        dbCity.getName(),
                        dbCity.getPostalCode()
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
            public Account toApi() {
                return new Account(
                        getId(),
                        getCreated(),
                        getFirstName(),
                        getLastName(),
                        getMail(),
                        getPassword(),
                        getPhone(),
                        getStrikes()
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
            public Long getOfferId() {
                return dbTerm.getOffer().getId();
            }

            @Override
            public Long getAccountId() {
                return dbTerm.getAccount().getId();
            }

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
                        getOfferId(),
                        getAccountId(),
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
}
