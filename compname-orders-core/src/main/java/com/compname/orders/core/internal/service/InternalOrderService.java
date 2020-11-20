package com.compname.orders.core.internal.service;

import com.compname.orders.api.message.request.business.CreateBusinessRequest;
import com.compname.orders.api.message.request.business.SearchBusinessRequest;
import com.compname.orders.api.message.request.business.UpdateBusinessRequest;
import com.compname.orders.api.message.request.city.CreateCityRequest;
import com.compname.orders.api.message.request.city.SearchCityRequest;
import com.compname.orders.api.message.request.offer.CreateOfferRequest;
import com.compname.orders.api.message.request.offer.SearchOfferRequest;
import com.compname.orders.api.model.business.Address;
import com.compname.orders.api.model.business.Business;
import com.compname.orders.api.model.business.ContactInfo;
import com.compname.orders.api.model.business.Geolocation;
import com.compname.orders.core.internal.model.InternalBusiness;
import com.compname.orders.core.internal.model.InternalCity;
import com.compname.orders.core.internal.model.InternalOffer;
import com.compname.orders.core.persistence.model.DbBusiness;
import com.compname.orders.core.persistence.repository.BusinessRepository;
import com.compname.orders.core.persistence.repository.CityRepository;
import com.compname.orders.core.persistence.repository.OfferRepository;
import com.compname.orders.core.persistence.repository.TermRepository;
import com.compname.orders.core.persistence.repository.AccountRepository;
import com.compname.orders.utility.OrdersServiceException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

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

    public List<InternalBusiness> search(SearchBusinessRequest request) {
        return null;
    }

    public InternalOffer create(CreateOfferRequest request) {
        return null;
    }

    public InternalOffer getOfferBy(Long id) {
        return null;
    }

    public List<InternalOffer> search(SearchOfferRequest request) {
        return null;
    }

    public InternalCity getCityBy(Long id) { return null; }

    public InternalCity create(CreateCityRequest request) {
        return null;
    }

    public List<InternalCity> search(SearchCityRequest request) {
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
                        dbBusiness.getAddress()
                );
            }

            @Override
            public ContactInfo getContactInfo() {
                return new ContactInfo(
                        dbBusiness.getPhone(),
                        dbBusiness.getMail(),
                        dbBusiness.getWebsite()
                );
            }

            @Override
            public Geolocation getGeolocation() {
                return new Geolocation(
                        dbBusiness.getLongitude(),
                        dbBusiness.getLatitude()
                );
            }

            @Override
            public String getMinInterval() {
                return dbBusiness.getMinInterval();
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
                        dbBusiness.getRating(),
                        getMinInterval()
                );
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public InternalBusiness delete()
            {
                defendDeleted();
                businessRepo.delete(dbBusiness);
                isDeleted.set(true);
                return this;
            }

            /**
             * Defends an already deleted entity.<br>
             */
            private void defendDeleted()
            {
                if (isDeleted.get())
                {
                    throw OrdersServiceException.validationError("DB Business entity already deleted [business=%s]", dbBusiness);
                }
            }

            @Override
            public InternalBusiness update(UpdateBusinessRequest request)
            {
                if (Objects.nonNull(request.getAddress())) { dbBusiness.setAddress(request.getAddress()); }
                if (Objects.nonNull(request.getMail())) { dbBusiness.setMail(request.getMail()); }
                if (Objects.nonNull(request.getCityId())) { dbBusiness.setCity(cityRepo.getOne(request.getCityId())); }
                if (Objects.nonNull(request.getLatitude())) { dbBusiness.setLatitude(request.getLatitude()); }
                if (Objects.nonNull(request.getLongitude())) { dbBusiness.setLongitude(request.getLongitude()); }
                if (Objects.nonNull(request.getMinInterval())) { dbBusiness.setMinInterval(request.getMinInterval()); }
                if (Objects.nonNull(request.getOib())) { dbBusiness.setOib(request.getOib()); }
                if (Objects.nonNull(request.getName())) { dbBusiness.setName(request.getName()); }
                if (Objects.nonNull(request.getPhone())) { dbBusiness.setPhone(request.getPhone()); }
                if (Objects.nonNull(request.getRating())) { dbBusiness.setRating(request.getRating()); }
                if (Objects.nonNull(request.getWebsite())) { dbBusiness.setWebsite(request.getWebsite()); }

                businessRepo.save(dbBusiness);

                return getBusinessBy(request.getId());
            }
        };
    }
}
