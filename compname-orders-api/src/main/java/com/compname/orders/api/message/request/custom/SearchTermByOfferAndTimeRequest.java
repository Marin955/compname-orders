package com.compname.orders.api.message.request.custom;

import com.compname.orders.api.message.request.ApiPaginationRequest;
import com.compname.orders.api.model.business.Geolocation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchTermByOfferAndTimeRequest extends ApiPaginationRequest {

    private String offer;
    private ZonedDateTime from;
    private ZonedDateTime to;
    private Long cityId;
    private Float longitude;
    private Float latitude;

    public SearchTermByOfferAndTimeRequest(Integer pageNumber, Integer pageSize, String offer, ZonedDateTime from, ZonedDateTime to, Long cityId, Float longitude, Float latitude) {
        super(pageNumber, pageSize);
        this.offer = offer;
        this.from = from;
        this.to = to;
        this.cityId = cityId;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
