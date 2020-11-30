package com.compname.orders.core.validation;

import com.compname.orders.api.message.request.custom.SearchTermByOfferAndTimeRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustomSearchRequestValidator extends AbstractRequestValidator {

    public SearchTermByOfferAndTimeRequest validate(SearchTermByOfferAndTimeRequest request) {
        validateBaseRequest(request);

        notEmpty(request.getOffer(), OFFER);
        notNull(request.getFrom(), FROM_TIME);
        notNull(request.getTo(), TO_TIME);

        return request;
    }
}