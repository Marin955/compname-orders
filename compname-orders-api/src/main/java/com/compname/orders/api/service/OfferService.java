package com.compname.orders.api.service;

import com.compname.orders.api.message.request.offer.*;
import com.compname.orders.api.message.response.offer.*;
import com.compname.orders.utility.OrdersServiceException;

public interface OfferService {
    CreateOfferResponse create(CreateOfferRequest request) throws OrdersServiceException;
    GetOfferResponse get(GetOfferRequest request) throws OrdersServiceException;
    DeleteOfferResponse delete(DeleteOfferRequest request) throws OrdersServiceException;
    SearchOfferResponse search(SearchOfferRequest request) throws OrdersServiceException;
    UpdateOfferResponse update(UpdateOfferRequest request) throws OrdersServiceException;
}
