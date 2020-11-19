package com.compname.orders.api.message.request.city;

import com.compname.orders.api.message.request.ApiPaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchCityRequest extends ApiPaginationRequest {

    private String name;
    private Integer postalCode;

    public SearchCityRequest(Integer pageNumber, Integer pageSize, String name, Integer postalCode) {
        super(pageNumber, pageSize);
        this.name = name;
        this.postalCode = postalCode;
    }
}
