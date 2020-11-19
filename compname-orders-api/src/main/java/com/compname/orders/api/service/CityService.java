package com.compname.orders.api.service;

import com.compname.orders.api.message.request.city.CreateCityRequest;
import com.compname.orders.api.message.request.city.DeleteCityRequest;
import com.compname.orders.api.message.request.city.GetCityRequest;
import com.compname.orders.api.message.request.city.SearchCityRequest;
import com.compname.orders.api.message.request.city.UpdateCityRequest;
import com.compname.orders.api.message.response.city.CreateCityResponse;
import com.compname.orders.api.message.response.city.DeleteCityResponse;
import com.compname.orders.api.message.response.city.GetCityResponse;
import com.compname.orders.api.message.response.city.SearchCityResponse;
import com.compname.orders.api.message.response.city.UpdateCityResponse;
import com.compname.orders.utility.OrdersServiceException;

public interface CityService {
    CreateCityResponse create(CreateCityRequest request) throws OrdersServiceException;
    GetCityResponse get(GetCityRequest request) throws OrdersServiceException;
    DeleteCityResponse delete(DeleteCityRequest request) throws OrdersServiceException;
    SearchCityResponse search(SearchCityRequest request) throws OrdersServiceException;
    UpdateCityResponse update(UpdateCityRequest request) throws OrdersServiceException;
}
