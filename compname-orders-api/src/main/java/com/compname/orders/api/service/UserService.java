package com.compname.orders.api.service;

import com.compname.orders.api.message.request.user.*;
import com.compname.orders.api.message.response.user.*;
import com.compname.orders.utility.OrdersServiceException;

public interface UserService {
    CreateUserResponse create(CreateUserRequest request) throws OrdersServiceException;
    GetUserResponse get(GetUserRequest request) throws OrdersServiceException;
    DeleteUserResponse delete(DeleteUserRequest request) throws OrdersServiceException;
    SearchUserResponse search(SearchUserRequest request) throws OrdersServiceException;
    UpdateUserResponse update(UpdateUserRequest request) throws OrdersServiceException;
}
