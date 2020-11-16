package com.compname.orders.api.message.response.business;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.message.response.ResponseCode;
import com.compname.orders.api.model.business.Business;

public class GetBusinessResponse extends ApiPayloadResponse<Business> {
    public GetBusinessResponse(ApiRequest request, ResponseCode responseCode, Business payload) {
        super(request, responseCode, payload);
    }
}
