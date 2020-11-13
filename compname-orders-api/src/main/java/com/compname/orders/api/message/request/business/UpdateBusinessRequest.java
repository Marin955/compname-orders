package com.compname.orders.api.message.request.business;

import com.compname.orders.api.message.request.ApiIdRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateBusinessRequest extends ApiIdRequest {

    private Long oib;
    private String name;
    private Long cityId;
    private String address;
    private Float longitude;
    private Float latitude;
    private String phone;
    private String mail;
    private String website;
    private Float rating;
    private String minInterval;

    public UpdateBusinessRequest(
            Long id,
            Long oib,
            String name,
            Long cityId,
            String address,
            Float longitude,
            Float latitude,
            String phone,
            String mail,
            String website,
            Float rating,
            String minInterval
    ) {
        super(id);
        this.oib = oib;
        this.name = name;
        this.cityId = cityId;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.phone = phone;
        this.mail = mail;
        this.website = website;
        this.rating = rating;
        this.minInterval = minInterval;
    }
}
