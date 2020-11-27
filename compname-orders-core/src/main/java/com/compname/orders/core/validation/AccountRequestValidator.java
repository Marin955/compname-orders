package com.compname.orders.core.validation;

import com.compname.orders.api.message.request.account.*;
import com.compname.orders.core.internal.model.InternalAccount;
import com.compname.orders.core.internal.service.InternalOrderService;
import com.compname.orders.utility.OrdersServiceException;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Objects;

@AllArgsConstructor
@Service
public class AccountRequestValidator extends AbstractRequestValidator {

    private static final String FIRST_NAME = "first name";
    private static final String LAST_NAME = "last name";
    private static final String PHONE = "phone";
    private static final String PASSWORD = "password";

    private final InternalOrderService service;
    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Long validate(GetAccountRequest request) {
        return validateIdRequest(request);
    }

    public Long validate(DeleteAccountRequest request) {
        return validateIdRequest(request);
    }

    public CreateAccountRequest validate(CreateAccountRequest request) {
        validateBaseRequest(request);

        if (Objects.isNull(request.getCreated())) {
            request.setCreated(ZonedDateTime.now());
        }
        notEmpty(request.getFirstName(), FIRST_NAME);
        notEmpty(request.getLastName(), LAST_NAME);
        notEmpty(request.getPassword(), PASSWORD);
        if(request.getPassword().length() < 6) {
            throw OrdersServiceException.validationError("Password too short, must be at least 6 characters.");
        }
        else if (request.getPassword().length() > 40) {
            throw OrdersServiceException.validationError("Password too long, can't be greater than 40 characters");
        }
        else {
            request.setPassword(encoder.encode(request.getPassword()));
        }
        notEmpty(request.getPhone(), PHONE);

        return request;
    }

    public SearchAccountRequest validate(SearchAccountRequest request) {
        return validatePaginationRequest(request);
    }

    public UpdateAccountRequest validate(UpdateAccountRequest request) {
        validateIdRequest(request);

        InternalAccount account = service.getAccountBy(request.getId());

        request.setFirstName(
                Objects.isNull(request.getFirstName())
                        ? account.getFirstName() : request.getFirstName());
        request.setLastName(
                Objects.isNull(request.getLastName())
                        ? account.getLastName() : request.getLastName());
        request.setPassword(
                Objects.isNull(request.getPassword())
                        ? account.getPassword() : request.getPassword());
        request.setMail(
                Objects.isNull(request.getMail())
                        ? account.getMail() : request.getMail());
        request.setPhone(
                Objects.isNull(request.getPhone())
                        ? account.getPhone() : request.getPhone());
        request.setStrikes(
                Objects.isNull(request.getStrikes())
                        ? account.getStrikes() : request.getStrikes());

        return request;
    }
}
