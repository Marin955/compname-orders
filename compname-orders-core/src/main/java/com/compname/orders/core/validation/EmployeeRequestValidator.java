package com.compname.orders.core.validation;

import com.compname.orders.api.message.request.employee.CreateEmployeeRequest;
import com.compname.orders.api.message.request.employee.DeleteEmployeeRequest;
import com.compname.orders.api.message.request.employee.GetEmployeeRequest;
import com.compname.orders.api.message.request.employee.SearchEmployeeRequest;
import com.compname.orders.api.message.request.employee.UpdateEmployeeRequest;
import com.compname.orders.core.internal.common.InternalIdEntity;
import com.compname.orders.core.internal.model.InternalEmployee;
import com.compname.orders.core.internal.service.InternalOrderService;
import com.compname.orders.utility.OrdersServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeRequestValidator extends AbstractRequestValidator {

    private static final String TITLE = "title";
    private final InternalOrderService service;

    public Long validate(GetEmployeeRequest request) {
        return validateIdRequest(request);
    }

    public Long validate(DeleteEmployeeRequest request) {
        return validateIdRequest(request);
    }

    public CreateEmployeeRequest validate(CreateEmployeeRequest request) {
        validateBaseRequest(request);

        if (Objects.isNull(request.getCreated())) {request.setCreated(ZonedDateTime.now());}
        notEmpty(request.getName(), NAME);
        notNull(request.getBusinessId(), BUSINESS_ID);
        notEmpty(request.getTitle(), TITLE);

        return request;
    }

    public SearchEmployeeRequest validate(SearchEmployeeRequest request) {
        return validatePaginationRequest(request);
    }

    public UpdateEmployeeRequest validate(UpdateEmployeeRequest request) {
        validateIdRequest(request);

        InternalEmployee internalEmployee = service.getEmployeeBy(request.getId());

        if (Objects.isNull(internalEmployee)) {
            throw OrdersServiceException.validationError("Entity does not exist [entity=%s]", request.getId());
        }
        request.setName(Objects.isNull(request.getName())
                ? internalEmployee.getName() : request.getName());
        request.setTitle(Objects.isNull(request.getTitle())
                ? internalEmployee.getTitle() : request.getTitle());
        request.setOfferIds(Objects.isNull(request.getOfferIds())
                ? internalEmployee.getOffers().stream().map(InternalIdEntity::getId).collect(Collectors.toSet())
                : request.getOfferIds());

        return request;
    }

}
