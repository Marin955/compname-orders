package com.compname.orders.api.message.request.city;

import com.compname.orders.api.message.request.ApiIdRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateCityRequest extends ApiIdRequest {
    private String name;
    private Integer postalCode;

    public CreateCityRequest(Long id, String name, Integer postalCode) {
        super(id);
        this.name = name;
        this.postalCode = postalCode;
    }
}
