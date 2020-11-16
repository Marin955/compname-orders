package com.compname.orders.core.peer;

import com.compname.orders.api.message.request.user.*;
import com.compname.orders.api.message.response.user.*;
import com.compname.orders.api.service.UserService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserPeer implements UserService {
    @Override
    public CreateUserResponse create(CreateUserRequest request) {
        return null;
    }

    @Override
    public GetUserResponse get(GetUserRequest request) {
        return null;
    }

    @Override
    public DeleteUserResponse delete(DeleteUserRequest request) {
        return null;
    }

    @Override
    public SearchUserResponse search(SearchUserRequest request) {
        return null;
    }

    @Override
    public UpdateUserResponse update(UpdateUserRequest request) {
        return null;
    }
}
