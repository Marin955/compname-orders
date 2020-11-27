package com.compname.orders.core.peer;

import com.compname.orders.api.message.request.employee.CreateEmployeeRequest;
import com.compname.orders.api.message.request.employee.DeleteEmployeeRequest;
import com.compname.orders.api.message.request.employee.GetEmployeeRequest;
import com.compname.orders.api.message.request.employee.SearchEmployeeRequest;
import com.compname.orders.api.message.request.employee.UpdateEmployeeRequest;
import com.compname.orders.api.message.response.employee.CreateEmployeeResponse;
import com.compname.orders.api.message.response.employee.DeleteEmployeeResponse;
import com.compname.orders.api.message.response.employee.GetEmployeeResponse;
import com.compname.orders.api.message.response.employee.SearchEmployeeResponse;
import com.compname.orders.api.message.response.employee.UpdateEmployeeResponse;
import com.compname.orders.api.model.employee.Employee;
import com.compname.orders.api.service.EmployeeService;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.service.InternalOrderService;
import com.compname.orders.core.validation.EmployeeRequestValidator;
import com.compname.orders.utility.OrdersServiceException;
import com.compname.orders.utility.ResponseCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class EmployeePeer implements EmployeeService {

    private final EmployeeRequestValidator validator;
    private final InternalOrderService service;

    @Override
    public CreateEmployeeResponse create(CreateEmployeeRequest request) throws OrdersServiceException
    {
        try{ validator.validate(request); } catch (OrdersServiceException exception) {
            return new CreateEmployeeResponse(request, ResponseCode.REQUEST_INVALID, null);
        }

        Employee employee = service.create(request).toApi();
        return new CreateEmployeeResponse(request, ResponseCode.OK, employee);
    }

    @Override
    public GetEmployeeResponse get(GetEmployeeRequest request) throws OrdersServiceException
    {
        Employee employee;
        try{
            validator.validate(request);
            employee = service.getEmployeeBy(request.getId()).toApi();
        } catch (OrdersServiceException exception) {
            return new GetEmployeeResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        catch (NullPointerException nullPointerException) {
            return new GetEmployeeResponse(request, ResponseCode.ENTITY_NOT_FOUND, null);
        }
        return new GetEmployeeResponse(request, ResponseCode.OK, employee);
    }

    @Override
    public DeleteEmployeeResponse delete(DeleteEmployeeRequest request)  throws OrdersServiceException
    {
        Long id;
        try{ id = validator.validate(request); } catch (OrdersServiceException exception) {
            return new DeleteEmployeeResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        Employee employee = service.getEmployeeBy(id).delete().toApi();
        return new DeleteEmployeeResponse(request, ResponseCode.OK, employee);
    }

    @Override
    public SearchEmployeeResponse search(SearchEmployeeRequest request) throws OrdersServiceException
    {
        try{ validator.validate(request); } catch (OrdersServiceException exception) {
            return new SearchEmployeeResponse(request, ResponseCode.REQUEST_INVALID, null, 0,0);
        }
        List<Employee> results = service.search(request).stream().map(ApiConvertible::toApi).collect(Collectors.toList());
        return new SearchEmployeeResponse(
                request, ResponseCode.OK, results, request.getPageNumber(), request.getPageSize()
        );
    }

    @Override
    public UpdateEmployeeResponse update(UpdateEmployeeRequest request) throws OrdersServiceException
    {
        try{ validator.validate(request); } catch (OrdersServiceException exception) {
            return new UpdateEmployeeResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        Employee employee = service.getEmployeeBy(request.getId()).update(request).toApi();
        return new UpdateEmployeeResponse(request, ResponseCode.OK, employee);
    }
}
