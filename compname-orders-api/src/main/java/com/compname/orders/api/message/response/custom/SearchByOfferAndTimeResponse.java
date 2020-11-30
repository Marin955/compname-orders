package com.compname.orders.api.message.response.custom;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPagedPayloadResponse;
import com.compname.orders.api.model.term.Term;
import com.compname.orders.utility.ResponseCode;

import java.util.List;

public class SearchByOfferAndTimeResponse extends ApiPagedPayloadResponse<Term> {
    public SearchByOfferAndTimeResponse(ApiRequest request, ResponseCode responseCode, List<Term> payload, Integer pageNumber, Integer pageSize) {
        super(request, responseCode, payload, pageNumber, pageSize);
    }
}
