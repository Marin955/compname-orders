package com.compname.orders.api.service;

import com.compname.orders.api.message.request.workhour.CreateWorkHourRequest;
import com.compname.orders.api.message.request.workhour.DeleteWorkHourRequest;
import com.compname.orders.api.message.request.workhour.GetWorkHourRequest;
import com.compname.orders.api.message.request.workhour.SearchWorkHourRequest;
import com.compname.orders.api.message.request.workhour.UpdateWorkHourRequest;
import com.compname.orders.api.message.response.workhour.CreateWorkHourResponse;
import com.compname.orders.api.message.response.workhour.DeleteWorkHourResponse;
import com.compname.orders.api.message.response.workhour.GetWorkHourResponse;
import com.compname.orders.api.message.response.workhour.SearchWorkHourResponse;
import com.compname.orders.api.message.response.workhour.UpdateWorkHourResponse;
import com.compname.orders.utility.OrdersServiceException;

public interface WorkHourService {
    CreateWorkHourResponse create(CreateWorkHourRequest request) throws OrdersServiceException;
    GetWorkHourResponse get(GetWorkHourRequest request) throws OrdersServiceException;
    DeleteWorkHourResponse delete(DeleteWorkHourRequest request) throws OrdersServiceException;
    SearchWorkHourResponse search(SearchWorkHourRequest request) throws OrdersServiceException;
    UpdateWorkHourResponse update(UpdateWorkHourRequest request) throws OrdersServiceException;
}
