package com.compname.orders.api.message.response.offer;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPagedPayloadResponse;
import com.compname.orders.utility.ResponseCode;
import com.compname.orders.api.model.offer.Offer;

import java.util.List;

public class SearchOfferResponse extends ApiPagedPayloadResponse<Offer> {
    public SearchOfferResponse(ApiRequest request, ResponseCode responseCode, List<Offer> payload, Integer pageNumber, Integer pageSize) {
        super(request, responseCode, payload, pageNumber, pageSize);
    }
}
