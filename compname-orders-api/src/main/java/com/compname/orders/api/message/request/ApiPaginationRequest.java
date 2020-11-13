package com.compname.orders.api.message.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiPaginationRequest extends ApiRequest {
    private Integer pageNumber;
    private Integer pageSize;
}
