package com.compname.orders.core.validation;

import com.compname.orders.api.message.request.user.*;
import org.springframework.stereotype.Service;

@Service
public class UserRequestValidator extends AbstractRequestValidator {

    private static final String FIRST_NAME = "first name";
    private static final String LAST_NAME = "last name";
    private static final String PHONE = "phone";
    private static final String PASSWORD = "password";

    public Long validate(GetUserRequest request) {
        return validateIdRequest(request);
    }

    public Long validate(DeleteUserRequest request) {
        return validateIdRequest(request);
    }

    public CreateUserRequest validate(CreateUserRequest request) {
        validateBaseRequest(request);

        notEmpty(request.getFirstName(), FIRST_NAME);
        notEmpty(request.getLastName(), LAST_NAME);
        notEmpty(request.getPassword(), PASSWORD);
        notEmpty(request.getPhone(), PHONE);

        return request;
    }

    public SearchUserRequest validate(SearchUserRequest request) {
        return validatePaginationRequest(request);
    }

    public UpdateUserRequest validate(UpdateUserRequest request) {
        validateIdRequest(request);
        return request;
    }
}
