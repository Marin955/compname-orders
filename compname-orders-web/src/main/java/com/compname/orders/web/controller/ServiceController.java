package com.compname.orders.web.controller;

import com.compname.orders.api.message.request.service.*;
import com.compname.orders.api.message.response.service.*;
import com.compname.orders.core.peer.ServicePeer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/service")
@RestController
public class ServiceController {

    private final ServicePeer peer;

    @PostMapping
    public @ResponseBody
    CreateServiceResponse create(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @RequestBody CreateServiceRequest request
    ) {
        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);

        return peer.create(request);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    GetServiceResponse get(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id
    ) {
        GetServiceRequest request = new GetServiceRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setId(id);

        return peer.get(request);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    DeleteServiceResponse delete(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id
    ) {
        DeleteServiceRequest request = new DeleteServiceRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setId(id);

        return peer.delete(request);
    }

    @GetMapping
    public @ResponseBody
    SearchServiceResponse search(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "businnesId", required = false) Long businessId,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber
    ) {
        SearchServiceRequest request = new SearchServiceRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setBusinessId(businessId);
        request.setName(name);
        request.setPageSize(pageSize);
        request.setPageNumber(pageNumber);

        return peer.search(request);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    UpdateServiceResponse update(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id,
            @RequestBody UpdateServiceRequest request
    ) {
        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);

        request.setId(id);

        return peer.update(request);
    }
}
