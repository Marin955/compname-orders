package com.compname.orders.api.message.response.term;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPagedPayloadResponse;
import com.compname.orders.utility.ResponseCode;
import com.compname.orders.api.model.term.Term;

import java.util.List;

public class SearchTermResponse extends ApiPagedPayloadResponse<Term> {
    public SearchTermResponse(ApiRequest request, ResponseCode responseCode, List<Term> payload, Integer pageNumber, Integer pageSize) {
        super(request, responseCode, payload, pageNumber, pageSize);
    }
}
