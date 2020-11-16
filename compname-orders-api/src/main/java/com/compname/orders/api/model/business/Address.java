package com.compname.orders.api.model.business;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Address {
    private String city;
    private Integer postalCode;
    private String address;
}
