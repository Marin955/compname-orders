package com.compname.orders.core.validation;

import com.compname.orders.api.message.request.business.*;
import com.compname.orders.core.internal.model.InternalBusiness;
import com.compname.orders.core.internal.model.InternalCity;
import com.compname.orders.core.internal.service.InternalOrderService;
import com.compname.orders.utility.OrdersServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Objects;

@AllArgsConstructor
@Service
public class BusinessRequestValidator extends AbstractRequestValidator {

    protected static final String DEFAULT_MIN_INTERVAL = "PT30M";

    private final InternalOrderService service;

    public Long validate(GetBusinessRequest request) {
        return validateIdRequest(request);
    }

    public Long validate(DeleteBusinessRequest request) {
        return validateIdRequest(request);
    }

    public CreateBusinessRequest validate(CreateBusinessRequest request) {
        validateBaseRequest(request);

        notEmpty(request.getName(), NAME);
        if (Objects.isNull(request.getCreated())) {
            request.setCreated(ZonedDateTime.now());
        }
        notEmpty(request.getCreatedBy(), CREATED_BY);
        notNull(request.getOib(), OIB);
        notNull(request.getCityId(), CITY);
        notNull(request.getAddress(), ADDRESS);
        notEmpty(request.getContactInfo().getPhone(), PHONE);
        notNull(request.getGeolocation().getLatitude(), LATITUDE);
        notNull(request.getGeolocation().getLongitude(), LONGITUDE);
        if ( Objects.isNull(request.getMinInterval()) || request.getMinInterval().isEmpty()) {
            request.setMinInterval(DEFAULT_MIN_INTERVAL);
        }
        return request;
    }

    public SearchBusinessRequest validate(SearchBusinessRequest request) {
        return validatePaginationRequest(request);
    }

    public UpdateBusinessRequest validate(UpdateBusinessRequest request) {
        validateIdRequest(request);

        InternalBusiness business = service.getBusinessBy(request.getId());
        InternalCity city = service.getCityByName(business.getAddress().getCity());

        request.setOib(
                Objects.isNull(request.getOib())
                        ? business.getOib() : request.getOib());
        request.setName(
                Objects.isNull(request.getName())
                        ? business.getName() : request.getName());
        request.setCityId(
                Objects.isNull(request.getCityId())
                        ? city.getId() : request.getCityId());
        request.setAddress(
                Objects.isNull(request.getAddress())
                        ? business.getAddress().getAddress() : request.getAddress());
        request.setLatitude(
                Objects.isNull(request.getLatitude())
                        ? business.getGeolocation().getLatitude() : request.getLatitude());
        request.setLongitude(
                Objects.isNull(request.getLongitude())
                        ? business.getGeolocation().getLongitude() : request.getLongitude());
        request.setMail(
                Objects.isNull(request.getMail())
                        ? business.getContactInfo().getMail() : request.getMail());
        request.setWebsite(
                Objects.isNull(request.getWebsite())
                        ? business.getContactInfo().getWebsite() : request.getWebsite());
        request.setPhone(
                Objects.isNull(request.getPhone())
                        ? business.getContactInfo().getPhone() : request.getPhone());
        request.setRating(
                Objects.isNull(request.getRating())
                        ? business.getRating() : request.getRating());
        request.setMinInterval(
                Objects.isNull(request.getMinInterval())
                        ? business.getMinInterval() : request.getMinInterval());

        return request;
    }
}