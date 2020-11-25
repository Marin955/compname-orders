package com.compname.orders.api.model.city;

import com.compname.orders.api.model.ApiIdEntity;
import com.compname.orders.api.model.business.Business;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class City extends ApiIdEntity {
    private String name;
    private Integer postalCode;
    private List<Business> businesses;

    public City(Long id, String name, Integer postalCode, List<Business> businesses) {
        super(id);
        this.name = name;
        this.postalCode = postalCode;
        this.businesses = businesses;
    }
}
