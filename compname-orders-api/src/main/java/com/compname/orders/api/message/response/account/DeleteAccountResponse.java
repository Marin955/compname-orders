package com.compname.orders.api.message.response.account;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.utility.ResponseCode;
import com.compname.orders.api.model.account.Account;

public class DeleteAccountResponse extends ApiPayloadResponse<Account> {
    public DeleteAccountResponse(ApiRequest request, ResponseCode responseCode, Account payload) {
        super(request, responseCode, payload);
    }
}
