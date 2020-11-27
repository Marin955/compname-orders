package com.compname.orders.api.message.response.employee;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.model.employee.Employee;
import com.compname.orders.utility.ResponseCode;

public class UpdateEmployeeResponse extends ApiPayloadResponse<Employee> {
    public UpdateEmployeeResponse(ApiRequest request, ResponseCode responseCode, Employee payload) {
        super(request, responseCode, payload);
    }
}
