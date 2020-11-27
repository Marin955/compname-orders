package com.compname.orders.api.service;

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
import com.compname.orders.utility.OrdersServiceException;

public interface EmployeeService {
    CreateEmployeeResponse create(CreateEmployeeRequest request) throws OrdersServiceException;
    GetEmployeeResponse get(GetEmployeeRequest request) throws OrdersServiceException;
    DeleteEmployeeResponse delete(DeleteEmployeeRequest request) throws OrdersServiceException;
    SearchEmployeeResponse search(SearchEmployeeRequest request) throws OrdersServiceException;
    UpdateEmployeeResponse update(UpdateEmployeeRequest request) throws OrdersServiceException;
}
