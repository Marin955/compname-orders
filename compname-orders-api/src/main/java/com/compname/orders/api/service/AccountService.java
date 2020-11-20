package com.compname.orders.api.service;

import com.compname.orders.api.message.request.account.*;
import com.compname.orders.api.message.response.account.*;
import com.compname.orders.utility.OrdersServiceException;

public interface AccountService {
    CreateAccountResponse create(CreateAccountRequest request) throws OrdersServiceException;
    GetAccountResponse get(GetAccountRequest request) throws OrdersServiceException;
    DeleteAccountResponse delete(DeleteAccountRequest request) throws OrdersServiceException;
    SearchAccountResponse search(SearchAccountRequest request) throws OrdersServiceException;
    UpdateAccountResponse update(UpdateAccountRequest request) throws OrdersServiceException;
}
