package com.compname.orders.api.message.response.employee;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPagedPayloadResponse;
import com.compname.orders.api.model.employee.Employee;
import com.compname.orders.utility.ResponseCode;

import java.util.List;

public class SearchEmployeeResponse extends ApiPagedPayloadResponse<Employee> {
    public SearchEmployeeResponse(ApiRequest request, ResponseCode responseCode, List<Employee> payload, Integer pageNumber, Integer pageSize) {
        super(request, responseCode, payload, pageNumber, pageSize);
    }
}
