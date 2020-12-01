package com.compname.orders.web.controller;

import com.compname.orders.api.message.request.city.CreateCityRequest;
import com.compname.orders.api.message.request.city.DeleteCityRequest;
import com.compname.orders.api.message.request.city.GetCityRequest;
import com.compname.orders.api.message.request.city.GetExtendedCityRequest;
import com.compname.orders.api.message.request.city.SearchCityRequest;
import com.compname.orders.api.message.request.city.SearchExtendedCityRequest;
import com.compname.orders.api.message.request.city.UpdateCityRequest;
import com.compname.orders.api.message.response.city.CreateCityResponse;
import com.compname.orders.api.message.response.city.DeleteCityResponse;
import com.compname.orders.api.message.response.city.GetCityResponse;
import com.compname.orders.api.message.response.city.GetExtendedCityResponse;
import com.compname.orders.api.message.response.city.SearchCityResponse;
import com.compname.orders.api.message.response.city.SearchExtendedCityResponse;
import com.compname.orders.api.message.response.city.UpdateCityResponse;
import com.compname.orders.core.peer.CityPeer;
import com.compname.orders.utility.OrdersServiceException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RequestMapping("/city")
@RestController
public class CityController {

    private final CityPeer peer;

    @PostMapping
    public @ResponseBody
    CreateCityResponse create(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @RequestBody CreateCityRequest request
    ) throws OrdersServiceException {
        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);

        return peer.create(request);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    GetCityResponse get(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id
    ) throws OrdersServiceException {
        GetCityRequest request = new GetCityRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setId(id);

        return peer.get(request);
    }

    @GetMapping("/extended/{id}")
    public @ResponseBody
    GetExtendedCityResponse getExtended(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id
    ) throws OrdersServiceException {
        GetExtendedCityRequest request = new GetExtendedCityRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setId(id);

        return peer.getExtended(request);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    DeleteCityResponse delete(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id
    ) throws OrdersServiceException {
        DeleteCityRequest request = new DeleteCityRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setId(id);

        return peer.delete(request);
    }

    @GetMapping
    public @ResponseBody
    SearchCityResponse search(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "postalCode", required = false) Integer postalCode,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber
    ) throws OrdersServiceException {
        SearchCityRequest request = new SearchCityRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setName(name);
        request.setPostalCode(postalCode);
        request.setPageSize(pageSize);
        request.setPageNumber(pageNumber);

        return peer.search(request);
    }

    @GetMapping("/extended")
    public @ResponseBody
    SearchExtendedCityResponse searchExtended(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "postalCode", required = false) Integer postalCode,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber
    ) throws OrdersServiceException {
        SearchExtendedCityRequest request = new SearchExtendedCityRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setName(name);
        request.setPostalCode(postalCode);
        request.setPageSize(pageSize);
        request.setPageNumber(pageNumber);

        return peer.searchExtended(request);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    UpdateCityResponse update(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id,
            @RequestBody UpdateCityRequest request
    ) throws OrdersServiceException {
        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);

        request.setId(id);

        return peer.update(request);
    }
}
