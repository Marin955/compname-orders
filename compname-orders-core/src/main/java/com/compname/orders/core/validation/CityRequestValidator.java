package com.compname.orders.core.validation;

import com.compname.orders.api.message.request.city.CreateCityRequest;
import com.compname.orders.api.message.request.city.DeleteCityRequest;
import com.compname.orders.api.message.request.city.GetCityRequest;
import com.compname.orders.api.message.request.city.GetExtendedCityRequest;
import com.compname.orders.api.message.request.city.SearchCityRequest;
import com.compname.orders.api.message.request.city.SearchExtendedCityRequest;
import com.compname.orders.api.message.request.city.UpdateCityRequest;
import com.compname.orders.core.internal.model.InternalCity;
import com.compname.orders.core.internal.service.InternalOrderService;
import com.compname.orders.utility.OrdersServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@AllArgsConstructor
@Service
public class CityRequestValidator extends AbstractRequestValidator {

    private final InternalOrderService service;

    public Long validate(GetCityRequest request) {
        return validateIdRequest(request);
    }

    public Long validate(GetExtendedCityRequest request) {
        return validateIdRequest(request);
    }

    public Long validate(DeleteCityRequest request) {
        return validateIdRequest(request);
    }

    public CreateCityRequest validate(CreateCityRequest request) {
        validateBaseRequest(request);

        notEmpty(request.getName(), NAME);
        notNull(request.getPostalCode(), POSTAL_CODE);
        return request;
    }

    public SearchCityRequest validate(SearchCityRequest request) { return validatePaginationRequest(request); }

    public SearchExtendedCityRequest validate(SearchExtendedCityRequest request) { return validatePaginationRequest(request); }

    public UpdateCityRequest validate(UpdateCityRequest request) {
        validateIdRequest(request);

        InternalCity internalCity = service.getCityBy(request.getId());

        if (Objects.isNull(internalCity)) {
            throw OrdersServiceException.validationError("Entity does not exist [entity=%s]", request.getId());
        }
        request.setName(Objects.isNull(request.getName())
                ? internalCity.getName() : request.getName());
        request.setPostalCode(Objects.isNull(request.getPostalCode())
                ? internalCity.getPostalCode() : request.getPostalCode());

        return request;
    }
}
