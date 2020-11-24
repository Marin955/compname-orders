package com.compname.orders.api.message.response.account;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.model.account.Account;
import com.compname.orders.utility.ResponseCode;

public class UpdateAccountResponse extends ApiPayloadResponse<Account> {
    public UpdateAccountResponse(ApiRequest request, ResponseCode responseCode, Account payload) {
        super(request, responseCode, payload);
    }
}
