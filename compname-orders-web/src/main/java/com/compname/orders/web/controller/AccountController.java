package com.compname.orders.web.controller;

import com.compname.orders.api.message.request.account.*;
import com.compname.orders.api.message.response.account.*;
import com.compname.orders.core.peer.AccountPeer;
import com.compname.orders.utility.OrdersServiceException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RequestMapping("/account")
@RestController
public class AccountController {

    private final AccountPeer peer;

    @PostMapping
    public @ResponseBody
    CreateAccountResponse create(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @RequestBody CreateAccountRequest request
    ) throws OrdersServiceException {
        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);

        return peer.create(request);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    GetAccountResponse get(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id
    ) throws OrdersServiceException {
        GetAccountRequest request = new GetAccountRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setId(id);

        return peer.get(request);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    DeleteAccountResponse delete(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id
    ) throws OrdersServiceException {
        DeleteAccountRequest request = new DeleteAccountRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setId(id);

        return peer.delete(request);
    }

    @GetMapping
    public @ResponseBody
    SearchAccountResponse search(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "strikes", required = false) Integer strikes,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber
    ) throws OrdersServiceException {
        SearchAccountRequest request = new SearchAccountRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setFirstName(firstName);
        request.setLastName(lastName);
        request.setPhone(phone);
        request.setStrikes(strikes);
        request.setPageSize(pageSize);
        request.setPageNumber(pageNumber);

        return peer.search(request);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    UpdateAccountResponse update(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id,
            @RequestBody UpdateAccountRequest request
    ) throws OrdersServiceException {
        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);

        request.setId(id);

        return peer.update(request);
    }
}
