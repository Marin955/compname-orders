package com.compname.orders.core.peer;

import com.compname.orders.api.message.request.user.*;
import com.compname.orders.api.message.response.user.*;
import com.compname.orders.api.service.UserService;
import com.compname.orders.core.validation.UserRequestValidator;
import com.compname.orders.utility.OrdersServiceException;
import com.compname.orders.utility.ResponseCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class UserPeer implements UserService {

    private final UserRequestValidator validator;

    @Override
    public CreateUserResponse create(CreateUserRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new CreateUserResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        return new CreateUserResponse(request, ResponseCode.OK, null);
    }

    @Override
    public GetUserResponse get(GetUserRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new GetUserResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        return new GetUserResponse(request, ResponseCode.OK, null);
    }

    @Override
    public DeleteUserResponse delete(DeleteUserRequest request)
    {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new DeleteUserResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        return new DeleteUserResponse(request, ResponseCode.OK, null);
    }

    @Override
    public SearchUserResponse search(SearchUserRequest request)
    {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new SearchUserResponse(request, ResponseCode.REQUEST_INVALID, null,0,0);
        }
        return new SearchUserResponse(request, ResponseCode.OK, null,0,0);
    }

    @Override
    public UpdateUserResponse update(UpdateUserRequest request)
    {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new UpdateUserResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        return new UpdateUserResponse(request, ResponseCode.OK, null);
    }
}
