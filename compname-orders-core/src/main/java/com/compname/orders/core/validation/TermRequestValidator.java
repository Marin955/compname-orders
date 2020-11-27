package com.compname.orders.core.validation;

import com.compname.orders.api.message.request.term.*;
import com.compname.orders.core.internal.model.InternalTerm;
import com.compname.orders.core.internal.service.InternalOrderService;
import com.compname.orders.utility.OrdersServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Objects;

@AllArgsConstructor
@Service
public class TermRequestValidator extends AbstractRequestValidator {

    private static final String FROM_TIME = "from time";
    private static final String TO_TIME = "to time";

    private final InternalOrderService service;

    public Long validate(GetTermRequest request) {
        return validateIdRequest(request);
    }

    public Long validate(DeleteTermRequest request) {
        return validateIdRequest(request);
    }

    public CreateTermRequest validate(CreateTermRequest request) {
        validateBaseRequest(request);

        if (Objects.isNull(request.getCreated())) {
            request.setCreated(ZonedDateTime.now());
        }
        notNull(request.getFrom(), FROM_TIME);
        notNull(request.getTo(), TO_TIME);
        notNull(request.getOfferId(), OFFER_ID);
        notNull(request.getEmployeeId(), EMPLOYEE_ID);

        return request;
    }

    public SearchTermRequest validate(SearchTermRequest request) {
        return validatePaginationRequest(request);
    }

    public UpdateTermRequest validate(UpdateTermRequest request) {
        validateIdRequest(request);

        InternalTerm internalTerm = service.getTermBy(request.getId());

        if (Objects.isNull(internalTerm)) {
            throw OrdersServiceException.validationError("Entity not found [entity=%s]", request.getId());
        }

        request.setFrom(Objects.isNull(request.getFrom())
                ? internalTerm.getFrom() : request.getFrom());
        request.setTo(Objects.isNull(request.getTo())
                ? internalTerm.getTo() : request.getTo());

        return request;
    }

}
