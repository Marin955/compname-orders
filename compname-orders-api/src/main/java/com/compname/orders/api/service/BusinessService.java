package com.compname.orders.api.service;

import com.compname.orders.api.message.request.business.*;
import com.compname.orders.api.message.response.business.*;
import com.compname.orders.utility.OrdersServiceException;

public interface BusinessService {
    CreateBusinessResponse create(CreateBusinessRequest request) throws OrdersServiceException;
    GetBusinessResponse get(GetBusinessRequest request) throws OrdersServiceException;
    DeleteBusinessResponse delete(DeleteBusinessRequest request) throws OrdersServiceException;
    SearchBusinessResponse search(SearchBusinessRequest request) throws OrdersServiceException;
    UpdateBusinessResponse update(UpdateBusinessRequest request) throws OrdersServiceException;
}
