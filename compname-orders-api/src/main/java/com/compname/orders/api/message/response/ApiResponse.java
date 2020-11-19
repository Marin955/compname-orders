package com.compname.orders.api.message.response;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.utility.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class ApiResponse {
    private ApiRequest request;
    private ResponseCode responseCode;
}
