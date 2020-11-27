package com.compname.orders.web.controller;

import com.compname.orders.api.message.request.employee.CreateEmployeeRequest;
import com.compname.orders.api.message.request.employee.DeleteEmployeeRequest;
import com.compname.orders.api.message.request.employee.GetEmployeeRequest;
import com.compname.orders.api.message.request.employee.SearchEmployeeRequest;
import com.compname.orders.api.message.request.employee.UpdateEmployeeRequest;
import com.compname.orders.api.message.response.employee.CreateEmployeeResponse;
import com.compname.orders.api.message.response.employee.DeleteEmployeeResponse;
import com.compname.orders.api.message.response.employee.GetEmployeeResponse;
import com.compname.orders.api.message.response.employee.SearchEmployeeResponse;
import com.compname.orders.api.message.response.employee.UpdateEmployeeResponse;
import com.compname.orders.core.peer.EmployeePeer;
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
@RequestMapping("/employee")
@RestController
public class EmployeeController {

    private final EmployeePeer peer;

    @PostMapping
    public @ResponseBody
    CreateEmployeeResponse create(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @RequestBody CreateEmployeeRequest request
    ) throws OrdersServiceException {
        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);

        return peer.create(request);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    GetEmployeeResponse get(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id
    ) throws OrdersServiceException {
        GetEmployeeRequest request = new GetEmployeeRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setId(id);

        return peer.get(request);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    DeleteEmployeeResponse delete(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id
    ) throws OrdersServiceException {
        DeleteEmployeeRequest request = new DeleteEmployeeRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setId(id);

        return peer.delete(request);
    }

    @GetMapping
    public @ResponseBody
    SearchEmployeeResponse search(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "businessId", required = false) Long businessId,
            @RequestParam(value = "offerId", required = false) Long offerId,
            @RequestParam(value = "pageSize", required = false) Integer pageSize,
            @RequestParam(value = "pageNumber", required = false) Integer pageNumber
    ) throws OrdersServiceException {
        SearchEmployeeRequest request = new SearchEmployeeRequest();

        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);
        request.setName(name);
        request.setBusinessId(businessId);
        request.setOfferId(offerId);
        request.setPageSize(pageSize);
        request.setPageNumber(pageNumber);

        return peer.search(request);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    UpdateEmployeeResponse update(
            @RequestHeader("providerId") Long providerId,
            @RequestHeader("channel") String channel,
            @RequestHeader("user") String user,
            @PathVariable("id") Long id,
            @RequestBody UpdateEmployeeRequest request
    ) throws OrdersServiceException {
        request.setProviderId(providerId);
        request.setChannel(channel);
        request.setUser(user);

        request.setId(id);

        return peer.update(request);
    }
}
