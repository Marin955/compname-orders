package com.compname.orders.api.service;

import com.compname.orders.api.message.request.term.*;
import com.compname.orders.api.message.response.term.*;
import com.compname.orders.utility.OrdersServiceException;

public interface TermService {
    CreateTermResponse create(CreateTermRequest request) throws OrdersServiceException;
    GetTermResponse get(GetTermRequest request) throws OrdersServiceException;
    DeleteTermResponse delete(DeleteTermRequest request) throws OrdersServiceException;
    SearchTermResponse search(SearchTermRequest request) throws OrdersServiceException;
    UpdateTermResponse update(UpdateTermRequest request) throws OrdersServiceException;
}
