package com.compname.orders.api.message.request.business;

import com.compname.orders.api.message.request.ApiBasicEntityRequest;
import com.compname.orders.api.model.business.ContactInfo;
import com.compname.orders.api.model.business.Geolocation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CreateBusinessRequest extends ApiBasicEntityRequest {

    private Long oib;
    private Long cityId;
    private String address;
    private ContactInfo contactInfo;
    private Geolocation geolocation;
    private String minInterval;

    public CreateBusinessRequest(Long id, String name, String createdBy, Long oib, Long cityId, String address, ContactInfo contactInfo, Geolocation geolocation, String minInterval) {
        super(id, name, createdBy);
        this.oib = oib;
        this.cityId = cityId;
        this.address = address;
        this.contactInfo = contactInfo;
        this.geolocation = geolocation;
        this.minInterval = minInterval;
    }

    public CreateBusinessRequest(String name, String createdBy, Long oib, Long cityId, String address, ContactInfo contactInfo, Geolocation geolocation, String minInterval) {
        super(name, createdBy);
        this.oib = oib;
        this.cityId = cityId;
        this.address = address;
        this.contactInfo = contactInfo;
        this.geolocation = geolocation;
        this.minInterval = minInterval;
    }
}
