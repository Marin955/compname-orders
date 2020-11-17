package com.compname.orders.api.message.response.user;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.utility.ResponseCode;
import com.compname.orders.api.model.user.User;

public class DeleteUserResponse extends ApiPayloadResponse<User> {
    public DeleteUserResponse(ApiRequest request, ResponseCode responseCode, User payload) {
        super(request, responseCode, payload);
    }
}
