package com.compname.orders.api.message.response.business;

import com.compname.orders.api.message.request.business.UpdateBusinessRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.model.business.Business;
import com.compname.orders.utility.ResponseCode;

public class UpdateBusinessResponse extends ApiPayloadResponse<Business> {

    public UpdateBusinessResponse(UpdateBusinessRequest request, ResponseCode responseCode, Business payload) {
        super(request, responseCode, payload);
    }
}