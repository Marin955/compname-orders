package com.compname.orders.api.model.business;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Geolocation {
    private Float longitude;
    private Float latitude;
}
