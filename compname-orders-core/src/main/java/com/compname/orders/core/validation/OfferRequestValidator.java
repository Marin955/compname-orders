package com.compname.orders.core.validation;

import com.compname.orders.api.message.request.offer.*;
import org.springframework.stereotype.Service;


@Service
public class OfferRequestValidator extends AbstractRequestValidator {

    public Long validate(GetOfferRequest request) {
        return validateIdRequest(request);
    }

    public Long validate(DeleteOfferRequest request) {
        return validateIdRequest(request);
    }

    public CreateOfferRequest validate(CreateOfferRequest request) {
        validateBaseRequest(request);

        notEmpty(request.getName(), NAME);
        notEmpty(request.getCreatedBy(), CREATED_BY);
        notNull(request.getCreated(), CREATED);
        notNull(request.getBusinessId(), BUSINESS_ID);

        return request;
    }

    public SearchOfferRequest validate(SearchOfferRequest request) {
        return validatePaginationRequest(request);
    }

    public UpdateOfferRequest validate(UpdateOfferRequest request) {
        validateIdRequest(request);
        return request;
    }
}
