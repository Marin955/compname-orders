package com.compname.orders.core.peer;

import com.compname.orders.api.message.request.term.*;
import com.compname.orders.api.message.response.term.*;
import com.compname.orders.api.service.TermService;
import com.compname.orders.core.validation.TermRequestValidator;
import com.compname.orders.utility.OrdersServiceException;
import com.compname.orders.utility.ResponseCode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class TermPeer implements TermService {

    private final TermRequestValidator validator;

    @Override
    public CreateTermResponse create(CreateTermRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new CreateTermResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        return new CreateTermResponse(request, ResponseCode.OK, null);
    }

    @Override
    public GetTermResponse get(GetTermRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new GetTermResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        return new GetTermResponse(request, ResponseCode.OK, null);
    }

    @Override
    public DeleteTermResponse delete(DeleteTermRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new DeleteTermResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        return new DeleteTermResponse(request, ResponseCode.OK, null);
    }

    @Override
    public SearchTermResponse search(SearchTermRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new SearchTermResponse(request, ResponseCode.REQUEST_INVALID, null,0,0);
        }
        return new SearchTermResponse(request, ResponseCode.OK, null,0,0);
    }

    @Override
    public UpdateTermResponse update(UpdateTermRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new UpdateTermResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        return new UpdateTermResponse(request, ResponseCode.OK, null);
    }
}
