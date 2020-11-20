package com.compname.orders.api.message.response.account;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPagedPayloadResponse;
import com.compname.orders.utility.ResponseCode;
import com.compname.orders.api.model.account.Account;

import java.util.List;

public class SearchAccountResponse extends ApiPagedPayloadResponse<Account> {
    public SearchAccountResponse(ApiRequest request, ResponseCode responseCode, List<Account> payload, Integer pageNumber, Integer pageSize) {
        super(request, responseCode, payload, pageNumber, pageSize);
    }
}
