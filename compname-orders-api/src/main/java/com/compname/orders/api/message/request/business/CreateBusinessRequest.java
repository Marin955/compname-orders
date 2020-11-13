package com.compname.orders.api.message.request.business;

import com.compname.orders.api.message.request.BasicEntity;
import com.compname.orders.api.model.Address;
import com.compname.orders.api.model.ContactInfo;
import com.compname.orders.api.model.Geolocation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CreateBusinessRequest extends BasicEntity {

    private Long oib;
    private Address address;
    private ContactInfo contactInfo;
    private Geolocation geolocation;
    private String minInterval;

    public CreateBusinessRequest(Long id, String name, String createdBy, Long oib, Address address, ContactInfo contactInfo, Geolocation geolocation, String minInterval) {
        super(id, name, createdBy);
        this.oib = oib;
        this.address = address;
        this.contactInfo = contactInfo;
        this.geolocation = geolocation;
        this.minInterval = minInterval;
    }

    public CreateBusinessRequest(String name, String createdBy, Long oib, Address address, ContactInfo contactInfo, Geolocation geolocation, String minInterval) {
        super(name, createdBy);
        this.oib = oib;
        this.address = address;
        this.contactInfo = contactInfo;
        this.geolocation = geolocation;
        this.minInterval = minInterval;
    }
}
