package com.compname.orders.core.validation;

import com.compname.orders.api.message.request.business.*;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Objects;

@Service
public class BusinessRequestValidator extends AbstractRequestValidator {

    protected static final String DEFAULT_MIN_INTERVAL = "PT30M";

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
        notEmpty(request.getAddress().getAddress(), ADDRESS);
        notEmpty(request.getAddress().getCity(), CITY);
        notNull(request.getAddress().getPostalCode(), POSTAL_CODE);
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
        return request;
    }
}