package com.compname.orders.api.message.response.user;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPagedPayloadResponse;
import com.compname.orders.api.message.response.ResponseCode;
import com.compname.orders.api.model.user.User;

import java.util.List;

public class SearchUserResponse extends ApiPagedPayloadResponse<User> {
    public SearchUserResponse(ApiRequest request, ResponseCode responseCode, List<User> payload, Integer pageNumber, Integer pageSize) {
        super(request, responseCode, payload, pageNumber, pageSize);
    }
}
