package com.compname.orders.api.message.response.business;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.model.business.Business;
import com.compname.orders.utility.ResponseCode;

public class DeleteBusinessResponse extends ApiPayloadResponse<Business> {
    public DeleteBusinessResponse(ApiRequest request, ResponseCode responseCode, Business payload) {
        super(request, responseCode, payload);
    }
}
