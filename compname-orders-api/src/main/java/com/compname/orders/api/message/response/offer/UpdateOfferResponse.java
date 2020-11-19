package com.compname.orders.api.message.response.offer;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.utility.ResponseCode;
import com.compname.orders.api.model.offer.Offer;
import com.compname.orders.api.model.offer.OfferFacade;

public class UpdateOfferResponse extends ApiPayloadResponse<Offer> implements OfferFacade {
    public UpdateOfferResponse(ApiRequest request, ResponseCode responseCode, Offer payload) {
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
