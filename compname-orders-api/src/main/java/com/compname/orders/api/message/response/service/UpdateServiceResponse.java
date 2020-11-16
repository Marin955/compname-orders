package com.compname.orders.api.message.response.service;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.message.response.ResponseCode;
import com.compname.orders.api.model.service.Service;
import com.compname.orders.api.model.service.ServiceFacade;

public class UpdateServiceResponse extends ApiPayloadResponse<Service> implements ServiceFacade {
    public UpdateServiceResponse(ApiRequest request, ResponseCode responseCode, Service payload) {
        super(request, responseCode, payload);
    }

    @Override
    public void setBusinessId(Long businessId) {
        this.getPayload().setBusinessId(businessId);
    }

    @Override
    public void setName(String name) {
        this.getPayload().setName(name);
    }

    @Override
    public void setPrice(Float price) {
        this.getPayload().setPrice(price);
    }

    @Override
    public void setDuration(String duration) {
        this.getPayload().setDuration(duration);
    }
}
