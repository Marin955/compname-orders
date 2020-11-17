package com.compname.orders.api.message.response.user;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.model.user.User;
import com.compname.orders.utility.ResponseCode;

public class GetUserResponse extends ApiPayloadResponse<User> {
    public GetUserResponse(ApiRequest request, ResponseCode responseCode, User payload) {
        super(request, responseCode, payload);
    }
}
