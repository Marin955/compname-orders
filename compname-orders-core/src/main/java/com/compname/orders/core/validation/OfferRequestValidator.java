package com.compname.orders.core.validation;

import com.compname.orders.api.message.request.offer.*;
import com.compname.orders.core.internal.model.InternalOffer;
import com.compname.orders.core.internal.service.InternalOrderService;
import com.compname.orders.utility.OrdersServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Objects;

@AllArgsConstructor
@Service
public class OfferRequestValidator extends AbstractRequestValidator {

    private final InternalOrderService service;

    public Long validate(GetOfferRequest request) {
        return validateIdRequest(request);
    }

    public Long validate(DeleteOfferRequest request) {
        return validateIdRequest(request);
    }

    public CreateOfferRequest validate(CreateOfferRequest request) {
        validateBaseRequest(request);

        if (Objects.isNull(request.getCreated())) {
            request.setCreated(ZonedDateTime.now());
        }
        notEmpty(request.getName(), NAME);
        notEmpty(request.getCreatedBy(), CREATED_BY);
        notNull(request.getCreated(), CREATED);
        notNull(request.getBusinessId(), BUSINESS_ID);

        return request;
    }

    public SearchOfferRequest validate(SearchOfferRequest request) {
        return validatePaginationRequest(request);
    }

    public UpdateOfferRequest validate(UpdateOfferRequest request) {
        validateIdRequest(request);

        InternalOffer internalOffer = service.getOfferBy(request.getId());

        if (Objects.isNull(internalOffer)) {
            throw OrdersServiceException.validationError("Entity not found [entity=%s]", request.getId());
        }

        request.setName(Objects.isNull(request.getName())
                ? internalOffer.getName() : request.getName());
        request.setDuration(Objects.isNull(request.getDuration())
                ? internalOffer.getDuration() : request.getDuration());
        request.setPrice(Objects.isNull(request.getPrice())
                ? internalOffer.getPrice() : request.getPrice());
        return request;
    }
}
