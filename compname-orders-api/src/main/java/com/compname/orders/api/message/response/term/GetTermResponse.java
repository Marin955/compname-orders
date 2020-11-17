package com.compname.orders.api.message.response.term;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.utility.ResponseCode;
import com.compname.orders.api.model.term.Term;

public class GetTermResponse extends ApiPayloadResponse<Term> {
    public GetTermResponse(ApiRequest request, ResponseCode responseCode, Term payload) {
        super(request, responseCode, payload);
    }
}
