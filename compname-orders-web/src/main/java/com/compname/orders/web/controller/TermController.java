package com.compname.orders.web.controller;

import com.compname.orders.api.message.request.term.*;
import com.compname.orders.api.message.response.term.*;
import com.compname.orders.core.peer.TermPeer;
import com.compname.orders.utility.OrdersServiceException;
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
    ) throws OrdersServiceException {
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
    ) throws OrdersServiceException {
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
    ) throws OrdersServiceException {
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
            @RequestParam(value = "offerId", required = false) Long offerId,
            @RequestParam(value = "accountId", required = false) Long accountId,
            @RequestParam(value = "from", required = false) ZonedDateTime from,
            @RequestParam(value = "to", required = false) ZonedDateTime to,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber
    ) throws OrdersServiceException {
        SearchTermRequest request = new SearchTermRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setOfferId(offerId);
        request.setAccountId(accountId);
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
    ) throws OrdersServiceException {
        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);

        request.setId(id);

        return peer.update(request);
    }
}
