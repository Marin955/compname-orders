package com.compname.orders.api.message.response.term;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.message.response.ResponseCode;
import com.compname.orders.api.model.term.Term;
import com.compname.orders.api.model.term.TermFacade;

import java.time.ZonedDateTime;

public class UpdateTermResponse extends ApiPayloadResponse<Term> implements TermFacade {
    public UpdateTermResponse(ApiRequest request, ResponseCode responseCode, Term payload) {
        super(request, responseCode, payload);
    }

    @Override
    public void setFrom(ZonedDateTime from) {
        this.getPayload().setFrom(from);
    }

    @Override
    public void setTo(ZonedDateTime to) {
        this.getPayload().setTo(to);
    }
}
