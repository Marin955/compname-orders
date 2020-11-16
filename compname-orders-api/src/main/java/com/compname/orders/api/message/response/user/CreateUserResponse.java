package com.compname.orders.api.message.response.user;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.message.response.ResponseCode;
import com.compname.orders.api.model.user.User;

public class CreateUserResponse extends ApiPayloadResponse<User> {
    public CreateUserResponse(ApiRequest request, ResponseCode responseCode, User payload) {
        super(request, responseCode, payload);
    }
}
