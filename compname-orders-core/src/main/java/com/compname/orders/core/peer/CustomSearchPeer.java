package com.compname.orders.core.peer;

import com.compname.orders.api.message.request.custom.SearchTermByOfferAndTimeRequest;
import com.compname.orders.api.message.response.custom.SearchByOfferAndTimeResponse;
import com.compname.orders.api.model.term.Term;
import com.compname.orders.api.service.CustomSearchService;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.service.InternalOrderService;
import com.compname.orders.core.validation.CustomSearchRequestValidator;
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
public class CustomSearchPeer implements CustomSearchService {

    private CustomSearchRequestValidator validator;
    private InternalOrderService service;

    @Override
    public SearchByOfferAndTimeResponse findByOfferAndTime(SearchTermByOfferAndTimeRequest request) {
        try {
            validator.validate(request);
        } catch (OrdersServiceException e) {
            return new SearchByOfferAndTimeResponse(request, ResponseCode.REQUEST_INVALID, null, 0,0);
        }
        List<Term> terms = service.findByOfferAndTime(request);
        return new SearchByOfferAndTimeResponse(request, ResponseCode.OK, terms, request.getPageNumber(), request.getPageSize());
    }
}
