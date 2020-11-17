package com.compname.orders.core.validation;

import com.compname.orders.api.message.request.term.*;
import org.springframework.stereotype.Service;

@Service
public class TermRequestValidator extends AbstractRequestValidator {

    private static final String FROM_TIME = "from time";
    private static final String TO_TIME = "to time";

    public Long validate(GetTermRequest request) {
        return validateIdRequest(request);
    }

    public Long validate(DeleteTermRequest request) {
        return validateIdRequest(request);
    }

    public CreateTermRequest validate(CreateTermRequest request) {
        validateBaseRequest(request);

        notNull(request.getFrom(), FROM_TIME);
        notNull(request.getTo(), TO_TIME);
        notNull(request.getServiceId(), SERVICE_ID);

        return request;
    }

    public SearchTermRequest validate(SearchTermRequest request) {
        return validatePaginationRequest(request);
    }

    public UpdateTermRequest validate(UpdateTermRequest request) {
        validateIdRequest(request);
        return request;
    }

}
