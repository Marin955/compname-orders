package com.compname.orders.api.message.response;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.utility.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public abstract class ApiPagedPayloadResponse<T> extends ApiPayloadResponse<List<T>> {

    private Integer pageNumber;
    private Integer pageSize;

    public ApiPagedPayloadResponse(ApiRequest request, ResponseCode responseCode, List<T> payload) {
        super(request, responseCode, payload);
    }

    public ApiPagedPayloadResponse(ApiRequest request, ResponseCode responseCode, List<T> payload, Integer pageNumber, Integer pageSize) {
        super(request, responseCode, payload);
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
