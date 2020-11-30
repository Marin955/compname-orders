package com.compname.orders.web.controller;

import com.compname.orders.api.message.request.custom.SearchTermByOfferAndTimeRequest;
import com.compname.orders.api.message.response.custom.SearchByOfferAndTimeResponse;
import com.compname.orders.core.peer.CustomSearchPeer;
import com.compname.orders.utility.OrdersServiceException;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@AllArgsConstructor
@RequestMapping("/custom_search")
@RestController
public class CustomSearchController {

    private final CustomSearchPeer peer;

    @GetMapping
    public @ResponseBody
    SearchByOfferAndTimeResponse searchByOfferAndTime(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @RequestParam(value = "offer", required = false) String offer,

            @RequestParam(value = "from", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                    ZonedDateTime from,

            @RequestParam(value = "to", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                    ZonedDateTime to,

            @RequestParam(value = "cityId", required = false) Long cityId,
            @RequestParam(value = "longitude", required = false) Float longitude,
            @RequestParam(value = "latitude", required = false) Float latitude,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber
    ) throws OrdersServiceException {
        SearchTermByOfferAndTimeRequest request = new SearchTermByOfferAndTimeRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setOffer(offer);
        request.setFrom(from);
        request.setTo(to);
        request.setCityId(cityId);
        request.setLongitude(longitude);
        request.setLatitude(latitude);
        request.setPageSize(pageSize);
        request.setPageNumber(pageNumber);

        return peer.findByOfferAndTime(request);
    }
}