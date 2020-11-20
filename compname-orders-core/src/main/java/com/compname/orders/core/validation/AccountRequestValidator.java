package com.compname.orders.core.validation;

import com.compname.orders.api.message.request.account.*;
import org.springframework.stereotype.Service;

@Service
public class AccountRequestValidator extends AbstractRequestValidator {

    private static final String FIRST_NAME = "first name";
    private static final String LAST_NAME = "last name";
    private static final String PHONE = "phone";
    private static final String PASSWORD = "password";

    public Long validate(GetAccountRequest request) {
        return validateIdRequest(request);
    }

    public Long validate(DeleteAccountRequest request) {
        return validateIdRequest(request);
    }

    public CreateAccountRequest validate(CreateAccountRequest request) {
        validateBaseRequest(request);

        notEmpty(request.getFirstName(), FIRST_NAME);
        notEmpty(request.getLastName(), LAST_NAME);
        notEmpty(request.getPassword(), PASSWORD);
        notEmpty(request.getPhone(), PHONE);

        return request;
    }

    public SearchAccountRequest validate(SearchAccountRequest request) {
        return validatePaginationRequest(request);
    }

    public UpdateAccountRequest validate(UpdateAccountRequest request) {
        validateIdRequest(request);
        return request;
    }
}
