package com.compname.orders.api.model.city;

import com.compname.orders.api.model.ApiIdEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City extends ApiIdEntity {
    private String name;
    private Integer postalCode;

    public City(Long id, String name, Integer postalCode) {
        super(id);
        this.name = name;
        this.postalCode = postalCode;
    }
}
