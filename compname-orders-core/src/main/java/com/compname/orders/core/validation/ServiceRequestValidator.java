package com.compname.orders.core.validation;

import com.compname.orders.api.message.request.service.*;
import org.springframework.stereotype.Service;


@Service
public class ServiceRequestValidator extends AbstractRequestValidator {

    public Long validate(GetServiceRequest request) {
        return validateIdRequest(request);
    }

    public Long validate(DeleteServiceRequest request) {
        return validateIdRequest(request);
    }

    public CreateServiceRequest validate(CreateServiceRequest request) {
        validateBaseRequest(request);

        notEmpty(request.getName(), NAME);
        notEmpty(request.getCreatedBy(), CREATED_BY);
        notNull(request.getCreated(), CREATED);
        notNull(request.getBusinessId(), BUSINESS_ID);

        return request;
    }

    public SearchServiceRequest validate(SearchServiceRequest request) {
        return validatePaginationRequest(request);
    }

    public UpdateServiceRequest validate(UpdateServiceRequest request) {
        validateIdRequest(request);
        return request;
    }
}
