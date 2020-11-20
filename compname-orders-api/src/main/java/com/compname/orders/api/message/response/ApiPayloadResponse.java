package com.compname.orders.api.message.response;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.model.ApiEntity;
import com.compname.orders.utility.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class ApiPayloadResponse<T> extends ApiResponse {
    private T payload;

    public ApiPayloadResponse(ApiRequest request, ResponseCode responseCode, T payload) {
        super(request, responseCode);
        this.payload = payload;
    }
}
