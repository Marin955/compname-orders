package com.compname.orders.api.message.response.account;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.model.account.Account;
import com.compname.orders.utility.ResponseCode;

public class GetAccountResponse extends ApiPayloadResponse<Account> {
    public GetAccountResponse(ApiRequest request, ResponseCode responseCode, Account payload) {
        super(request, responseCode, payload);
    }
}
