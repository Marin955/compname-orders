package com.compname.orders.api.service;

import com.compname.orders.api.message.request.user.*;
import com.compname.orders.api.message.response.user.*;

public interface UserService {
    CreateUserResponse create(CreateUserRequest request);
    GetUserResponse get(GetUserRequest request);
    DeleteUserResponse delete(DeleteUserRequest request);
    SearchUserResponse search(SearchUserRequest request);
    UpdateUserResponse update(UpdateUserRequest request);
}
