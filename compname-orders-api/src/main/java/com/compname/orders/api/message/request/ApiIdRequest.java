package com.compname.orders.api.message.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public abstract class ApiIdRequest extends ApiRequest {
    private Long id;
}
