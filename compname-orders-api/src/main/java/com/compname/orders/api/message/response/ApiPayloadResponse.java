package com.compname.orders.api.message.response;

import com.compname.orders.api.message.request.ApiRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public abstract class ApiPayloadResponse<T> {
    private ApiRequest request;
    private ResponseCode responseCode;
    private T payload;
}
