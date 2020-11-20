package com.compname.orders.core.peer;

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
import com.compname.orders.api.model.city.City;
import com.compname.orders.api.service.CityService;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.service.InternalOrderService;
import com.compname.orders.core.validation.CityRequestValidator;
import com.compname.orders.utility.OrdersServiceException;
import com.compname.orders.utility.ResponseCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Transactional
public class CityPeer implements CityService {
    private final CityRequestValidator validator;
    private final InternalOrderService service;

    @Override
    public CreateCityResponse create(CreateCityRequest request) throws OrdersServiceException
    {
        try{ validator.validate(request); } catch (OrdersServiceException exception) {
            return new CreateCityResponse(request, ResponseCode.REQUEST_INVALID, null);
        }

        City city = service.create(request).toApi();
        return new CreateCityResponse(request, ResponseCode.OK, city);
    }

    @Override
    public GetCityResponse get(GetCityRequest request) throws OrdersServiceException
    {
        Long id;
        try{ id = validator.validate(request); } catch (OrdersServiceException exception) {
            return new GetCityResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        City city = service.getCityBy(id).toApi();
        return new GetCityResponse(request, ResponseCode.OK, city);
    }

    @Override
    public DeleteCityResponse delete(DeleteCityRequest request)  throws OrdersServiceException
    {
        Long id;
        try{ id = validator.validate(request); } catch (OrdersServiceException exception) {
            return new DeleteCityResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        City city = service.getCityBy(id).delete().toApi();
        return new DeleteCityResponse(request, ResponseCode.OK, null);
    }

    @Override
    public SearchCityResponse search(SearchCityRequest request) throws OrdersServiceException
    {
        try{ validator.validate(request); } catch (OrdersServiceException exception) {
            return new SearchCityResponse(request, ResponseCode.REQUEST_INVALID, null, 0,0);
        }
        List<City> results = service.search(request).stream().map(ApiConvertible::toApi).collect(Collectors.toList());
        return new SearchCityResponse(
                request, ResponseCode.OK, results, request.getPageNumber(), request.getPageSize()
        );
    }

    @Override
    public UpdateCityResponse update(UpdateCityRequest request) throws OrdersServiceException
    {
        try{ validator.validate(request); } catch (OrdersServiceException exception) {
            return new UpdateCityResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        City city = service.getCityBy(request.getId()).update(request).toApi();
        return new UpdateCityResponse(request, ResponseCode.OK, city);
    }
}