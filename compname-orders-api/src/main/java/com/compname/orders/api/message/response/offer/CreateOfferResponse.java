package com.compname.orders.api.message.response.offer;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.utility.ResponseCode;
import com.compname.orders.api.model.offer.Offer;

public class CreateOfferResponse extends ApiPayloadResponse<Offer> {
    public CreateOfferResponse(ApiRequest request, ResponseCode responseCode, Offer payload) {
        super(request, responseCode, payload);
    }
}
