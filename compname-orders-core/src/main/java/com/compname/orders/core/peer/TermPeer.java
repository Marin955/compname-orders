package com.compname.orders.core.peer;

import com.compname.orders.api.message.request.term.*;
import com.compname.orders.api.message.response.term.*;
import com.compname.orders.api.model.term.Term;
import com.compname.orders.api.service.TermService;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.service.InternalOrderService;
import com.compname.orders.core.validation.TermRequestValidator;
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
public class TermPeer implements TermService {

    private final InternalOrderService service;
    private final TermRequestValidator validator;

    @Override
    public CreateTermResponse create(CreateTermRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new CreateTermResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        Term term = service.create(request).toApi();
        return new CreateTermResponse(request, ResponseCode.OK, term);
    }

    @Override
    public GetTermResponse get(GetTermRequest request) {
        Term term;
        try{
            validator.validate(request);
            term = service.getTermBy(request.getId()).toApi();
        } catch (OrdersServiceException exception) {
            return new GetTermResponse(request, ResponseCode.REQUEST_INVALID, null);
        } catch (NullPointerException nullPointerException) {
            return new GetTermResponse(request, ResponseCode.ENTITY_NOT_FOUND, null);
        }
        return new GetTermResponse(request, ResponseCode.OK, term);
    }

    @Override
    public DeleteTermResponse delete(DeleteTermRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new DeleteTermResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        Term term = service.getTermBy(request.getId()).delete().toApi();
        return new DeleteTermResponse(request, ResponseCode.OK, term);
    }

    @Override
    public SearchTermResponse search(SearchTermRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new SearchTermResponse(request, ResponseCode.REQUEST_INVALID, null,0,0);
        }
        List<Term> results = service.search(request).stream().map(ApiConvertible::toApi).collect(Collectors.toList());
    return new SearchTermResponse(
        request, ResponseCode.OK, results, request.getPageNumber(), request.getPageSize());
    }

    @Override
    public UpdateTermResponse update(UpdateTermRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new UpdateTermResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        Term term = service.getTermBy(request.getId()).update(request).toApi();
        return new UpdateTermResponse(request, ResponseCode.OK, term);
    }
}
