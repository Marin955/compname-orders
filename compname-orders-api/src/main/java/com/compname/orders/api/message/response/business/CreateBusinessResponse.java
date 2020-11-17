package com.compname.orders.api.message.response.business;

import com.compname.orders.api.message.request.business.CreateBusinessRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.model.business.Business;
import com.compname.orders.utility.ResponseCode;

public class CreateBusinessResponse extends ApiPayloadResponse<Business> {
    public CreateBusinessResponse(CreateBusinessRequest request, ResponseCode responseCode, Business payload) {
        super(request, responseCode, payload);
    }
}
