package com.compname.orders.api.message.response.service;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.utility.ResponseCode;
import com.compname.orders.api.model.service.Service;

public class GetServiceResponse extends ApiPayloadResponse<Service> {
    public GetServiceResponse(ApiRequest request, ResponseCode responseCode, Service payload) {
        super(request, responseCode, payload);
    }
}
