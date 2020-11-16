package com.compname.orders.api.message.response.service;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.message.response.ResponseCode;
import com.compname.orders.api.model.service.Service;

public class CreateServiceResponse extends ApiPayloadResponse<Service> {
    public CreateServiceResponse(ApiRequest request, ResponseCode responseCode, Service payload) {
        super(request, responseCode, payload);
    }
}
