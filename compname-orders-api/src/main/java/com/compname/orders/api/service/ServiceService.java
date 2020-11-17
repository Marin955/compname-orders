package com.compname.orders.api.service;

import com.compname.orders.api.message.request.service.*;
import com.compname.orders.api.message.response.service.*;
import com.compname.orders.utility.OrdersServiceException;

public interface ServiceService {
    CreateServiceResponse create(CreateServiceRequest request) throws OrdersServiceException;
    GetServiceResponse get(GetServiceRequest request) throws OrdersServiceException;
    DeleteServiceResponse delete(DeleteServiceRequest request) throws OrdersServiceException;
    SearchServiceResponse search(SearchServiceRequest request) throws OrdersServiceException;
    UpdateServiceResponse update(UpdateServiceRequest request) throws OrdersServiceException;
}
