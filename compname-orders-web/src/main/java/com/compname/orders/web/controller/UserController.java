package com.compname.orders.web.controller;

import com.compname.orders.api.message.request.user.*;
import com.compname.orders.api.message.response.user.*;
import com.compname.orders.core.peer.UserPeer;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@AllArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserPeer peer;

    @PostMapping
    public @ResponseBody
    CreateUserResponse create(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @RequestBody CreateUserRequest request
    ) {
        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);

        return peer.create(request);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    GetUserResponse get(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id
    ) {
        GetUserRequest request = new GetUserRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setId(id);

        return peer.get(request);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    DeleteUserResponse delete(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id
    ) {
        DeleteUserRequest request = new DeleteUserRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setId(id);

        return peer.delete(request);
    }

    @GetMapping
    public @ResponseBody
    SearchUserResponse search(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @RequestParam(value = "firstName", required = false) String firstName,
            @RequestParam(value = "lastName", required = false) String lastName,
            @RequestParam(value = "phone", required = false) String phone,
            @RequestParam(value = "strikes", required = false) Integer strikes,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber
    ) {
        SearchUserRequest request = new SearchUserRequest();

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
    UpdateUserResponse update(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id,
            @RequestBody UpdateUserRequest request
    ) {
        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);

        request.setId(id);

        return peer.update(request);
    }
}
