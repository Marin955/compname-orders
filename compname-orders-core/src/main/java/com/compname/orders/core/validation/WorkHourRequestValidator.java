package com.compname.orders.core.validation;

import com.compname.orders.api.message.request.workhour.CreateWorkHourRequest;
import com.compname.orders.api.message.request.workhour.DeleteWorkHourRequest;
import com.compname.orders.api.message.request.workhour.GetWorkHourRequest;
import com.compname.orders.api.message.request.workhour.SearchWorkHourRequest;
import com.compname.orders.api.message.request.workhour.UpdateWorkHourRequest;
import com.compname.orders.core.internal.model.InternalWorkHour;
import com.compname.orders.core.internal.service.InternalOrderService;
import com.compname.orders.utility.OrdersServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
public class WorkHourRequestValidator extends AbstractRequestValidator {

    private static final String FROM_TIME = "from time";
    private static final String TO_TIME = "to time";

    private final InternalOrderService service;

    public Long validate(GetWorkHourRequest request) {
        return validateIdRequest(request);
    }

    public Long validate(DeleteWorkHourRequest request) {
        return validateIdRequest(request);
    }

    public CreateWorkHourRequest validate(CreateWorkHourRequest request) {
        validateBaseRequest(request);

        notNull(request.getFrom(), FROM_TIME);
        notNull(request.getTo(), TO_TIME);
        notNull(request.getEmployeeId(), EMPLOYEE_ID);

        return request;
    }

    public SearchWorkHourRequest validate(SearchWorkHourRequest request) {
        return validatePaginationRequest(request);
    }

    public UpdateWorkHourRequest validate(UpdateWorkHourRequest request) {
        validateIdRequest(request);

        InternalWorkHour internalWorkHour = service.getWorkHourBy(request.getId());

        if (Objects.isNull(internalWorkHour)) {
            throw OrdersServiceException.validationError("Entity not found [entity=%s]", request.getId());
        }

        request.setFrom(Objects.isNull(request.getFrom())
                ? internalWorkHour.getFrom() : request.getFrom());
        request.setTo(Objects.isNull(request.getTo())
                ? internalWorkHour.getTo() : request.getTo());

        return request;
    }
}
