package com.compname.orders.api.message.response.account;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.model.account.Account;
import com.compname.orders.api.model.account.AccountFacade;
import com.compname.orders.utility.ResponseCode;

public class UpdateAccountResponse extends ApiPayloadResponse<Account> implements AccountFacade {
    public UpdateAccountResponse(ApiRequest request, ResponseCode responseCode, Account payload) {
        super(request, responseCode, payload);
    }

    @Override
    public void setFirstName(String firstName) {
        this.getPayload().setFirstName(firstName);
    }

    @Override
    public void setLastName(String lastName) {
        this.getPayload().setLastName(lastName);
    }

    @Override
    public void setMail(String mail) {
        this.getPayload().setMail(mail);
    }

    @Override
    public void setPassword(String password) {
        this.getPayload().setPassword(password);
    }

    @Override
    public void setPhone(String phone) {
        this.getPayload().setPhone(phone);
    }

    @Override
    public void setStrikes(Integer strikes) {
        this.getPayload().setStrikes(strikes);
    }
}
