package com.compname.orders.core.validation;

import com.compname.orders.api.message.request.city.CreateCityRequest;
import com.compname.orders.api.message.request.city.DeleteCityRequest;
import com.compname.orders.api.message.request.city.GetCityRequest;
import com.compname.orders.api.message.request.city.SearchCityRequest;
import com.compname.orders.api.message.request.city.UpdateCityRequest;
import org.springframework.stereotype.Service;

@Service
public class CityRequestValidator extends AbstractRequestValidator {

    public Long validate(GetCityRequest request) {
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

    public SearchCityRequest validate(SearchCityRequest request) {
        return validatePaginationRequest(request);
    }

    public UpdateCityRequest validate(UpdateCityRequest request) {
        validateIdRequest(request);
        return request;
    }
}
