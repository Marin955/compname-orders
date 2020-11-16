package com.compname.orders.api.message.response.user;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.message.response.ResponseCode;
import com.compname.orders.api.model.user.User;
import com.compname.orders.api.model.user.UserFacade;

public class UpdateUserResponse extends ApiPayloadResponse<User> implements UserFacade {
    public UpdateUserResponse(ApiRequest request, ResponseCode responseCode, User payload) {
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
