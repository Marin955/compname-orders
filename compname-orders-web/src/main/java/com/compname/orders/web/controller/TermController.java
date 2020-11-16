package com.compname.orders.web.controller;

import com.compname.orders.api.message.request.term.*;
import com.compname.orders.api.message.response.term.*;
import com.compname.orders.core.peer.TermPeer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@AllArgsConstructor
@RequestMapping("/term")
@RestController
public class TermController {

    private final TermPeer peer;

    @PostMapping
    public @ResponseBody
    CreateTermResponse create(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @RequestBody CreateTermRequest request
    ) {
        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);

        return peer.create(request);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    GetTermResponse get(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id
    ) {
        GetTermRequest request = new GetTermRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setId(id);

        return peer.get(request);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    DeleteTermResponse delete(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id
    ) {
        DeleteTermRequest request = new DeleteTermRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setId(id);

        return peer.delete(request);
    }

    @GetMapping
    public @ResponseBody
    SearchTermResponse search(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @RequestParam(value = "serviceId", required = false) Long serviceId,
            @RequestParam(value = "userId", required = false) Long userId,
            @RequestParam(value = "from", required = false) ZonedDateTime from,
            @RequestParam(value = "to", required = false) ZonedDateTime to,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber
    ) {
        SearchTermRequest request = new SearchTermRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setServiceId(serviceId);
        request.setUserId(userId);
        request.setFrom(from);
        request.setTo(to);
        request.setPageSize(pageSize);
        request.setPageNumber(pageNumber);

        return peer.search(request);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    UpdateTermResponse update(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id,
            @RequestBody UpdateTermRequest request
    ) {
        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);

        request.setId(id);

        return peer.update(request);
    }
}
