package com.compname.orders.core.peer;

import com.compname.orders.api.message.request.offer.*;
import com.compname.orders.api.message.response.offer.*;
import com.compname.orders.api.model.offer.Offer;
import com.compname.orders.api.service.OfferService;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.service.InternalOrderService;
import com.compname.orders.core.validation.OfferRequestValidator;
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
public class OfferPeer implements OfferService {

    private final OfferRequestValidator validator;
    private final InternalOrderService service;

    @Override
    public CreateOfferResponse create(CreateOfferRequest request) {
        try{ validator.validate(request); } catch (OrdersServiceException exception) {
            return new CreateOfferResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        Offer offer = service.create(request).toApi();
        return new CreateOfferResponse(request, ResponseCode.OK, offer);
    }

    @Override
    public GetOfferResponse get(GetOfferRequest request) {
        Long id;
        try{ id = validator.validate(request); } catch (OrdersServiceException exception) {
            return new GetOfferResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        Offer offer = service.getOfferBy(id).toApi();
        return new GetOfferResponse(request, ResponseCode.OK, offer);
    }

    @Override
    public DeleteOfferResponse delete(DeleteOfferRequest request) {
        Long id;
        try{ id = validator.validate(request); } catch (OrdersServiceException exception) {
            return new DeleteOfferResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        Offer offer = service.getOfferBy(id).toApi();
        return new DeleteOfferResponse(request, ResponseCode.OK, offer);
    }

    @Override
    public SearchOfferResponse search(SearchOfferRequest request) {
        try{ validator.validate(request); } catch (OrdersServiceException exception) {
            return new SearchOfferResponse(request, ResponseCode.REQUEST_INVALID, null, 0, 0);
        }
        List<Offer> results = service.search(request).stream().map(ApiConvertible::toApi).collect(Collectors.toList());
        return new SearchOfferResponse(
            request, ResponseCode.OK, results, request.getPageNumber(), request.getPageSize()
        );
    }

    @Override
    public UpdateOfferResponse update(UpdateOfferRequest request) {
        try{ validator.validate(request); } catch (OrdersServiceException exception) {
            return new UpdateOfferResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        Offer offer = service.getOfferBy(request.getId()).update(request).toApi();
        return new UpdateOfferResponse(request, ResponseCode.OK, offer);
    }
}
