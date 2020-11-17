package com.compname.orders.core.peer;

import com.compname.orders.api.message.request.business.*;
import com.compname.orders.api.message.response.business.*;
import com.compname.orders.api.service.BusinessService;
import com.compname.orders.core.validation.BusinessRequestValidator;
import com.compname.orders.utility.OrdersServiceException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@AllArgsConstructor
@Service
@Transactional
public class BusinessPeer implements BusinessService {

    private final BusinessRequestValidator validator;

    @Override
    public CreateBusinessResponse create(CreateBusinessRequest request) throws OrdersServiceException
    {
        validator.validate(request);
        return null;
    }

    @Override
    public GetBusinessResponse get(GetBusinessRequest request) throws OrdersServiceException
    {
        validator.validate(request);
        return null;
    }

    @Override
    public DeleteBusinessResponse delete(DeleteBusinessRequest request)  throws OrdersServiceException
    {
        validator.validate(request);
        return null;
    }

    @Override
    public SearchBusinessResponse search(SearchBusinessRequest request) throws OrdersServiceException
    {
        validator.validate(request);
        return null;
    }

    @Override
    public UpdateBusinessResponse update(UpdateBusinessRequest request) throws OrdersServiceException
    {
        validator.validate(request);
        return null;
    }
}
