package com.compname.orders.api.message.response.employee;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.model.employee.Employee;
import com.compname.orders.utility.ResponseCode;

public class CreateEmployeeResponse extends ApiPayloadResponse<Employee> {
    public CreateEmployeeResponse(ApiRequest request, ResponseCode responseCode, Employee payload) {
        super(request, responseCode, payload);
    }
}
