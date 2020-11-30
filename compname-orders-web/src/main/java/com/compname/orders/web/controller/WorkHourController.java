package com.compname.orders.web.controller;

import com.compname.orders.api.message.request.workhour.CreateWorkHourRequest;
import com.compname.orders.api.message.request.workhour.DeleteWorkHourRequest;
import com.compname.orders.api.message.request.workhour.GetWorkHourRequest;
import com.compname.orders.api.message.request.workhour.SearchWorkHourRequest;
import com.compname.orders.api.message.request.workhour.UpdateWorkHourRequest;
import com.compname.orders.api.message.response.workhour.CreateWorkHourResponse;
import com.compname.orders.api.message.response.workhour.DeleteWorkHourResponse;
import com.compname.orders.api.message.response.workhour.GetWorkHourResponse;
import com.compname.orders.api.message.response.workhour.SearchWorkHourResponse;
import com.compname.orders.api.message.response.workhour.UpdateWorkHourResponse;
import com.compname.orders.core.peer.WorkHourPeer;
import com.compname.orders.utility.OrdersServiceException;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
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

import java.time.ZonedDateTime;

@AllArgsConstructor
@RequestMapping("/workhour")
@RestController
public class WorkHourController {

    private final WorkHourPeer peer;

    @PostMapping
    public @ResponseBody
    CreateWorkHourResponse create(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @RequestBody CreateWorkHourRequest request
    ) throws OrdersServiceException {
        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);

        return peer.create(request);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    GetWorkHourResponse get(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id
    ) throws OrdersServiceException {
        GetWorkHourRequest request = new GetWorkHourRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setId(id);

        return peer.get(request);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    DeleteWorkHourResponse delete(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id
    ) throws OrdersServiceException {
        DeleteWorkHourRequest request = new DeleteWorkHourRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setId(id);

        return peer.delete(request);
    }

    @GetMapping
    public @ResponseBody
    SearchWorkHourResponse search(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @RequestParam(value = "employeeId", required = false) Long employeeId,

            @RequestParam(value = "from", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                    ZonedDateTime from,

            @RequestParam(value = "to", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
                    ZonedDateTime to,

            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber
    ) throws OrdersServiceException {
        SearchWorkHourRequest request = new SearchWorkHourRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setEmployeeId(employeeId);
        request.setFrom(from);
        request.setTo(to);
        request.setPageSize(pageSize);
        request.setPageNumber(pageNumber);

        return peer.search(request);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    UpdateWorkHourResponse update(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id,
            @RequestBody UpdateWorkHourRequest request
    ) throws OrdersServiceException {
        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);

        request.setId(id);

        return peer.update(request);
    }
}
