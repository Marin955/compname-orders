package com.compname.orders.core.peer;

import com.compname.orders.api.message.request.business.CreateBusinessRequest;
import com.compname.orders.api.message.request.business.DeleteBusinessRequest;
import com.compname.orders.api.message.request.business.GetBusinessRequest;
import com.compname.orders.api.message.request.business.SearchBusinessRequest;
import com.compname.orders.api.message.request.business.UpdateBusinessRequest;
import com.compname.orders.api.message.response.business.CreateBusinessResponse;
import com.compname.orders.api.message.response.business.DeleteBusinessResponse;
import com.compname.orders.api.message.response.business.GetBusinessResponse;
import com.compname.orders.api.message.response.business.SearchBusinessResponse;
import com.compname.orders.api.message.response.business.UpdateBusinessResponse;
import com.compname.orders.api.model.business.Business;
import com.compname.orders.api.service.BusinessService;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.service.InternalOrderService;
import com.compname.orders.core.validation.BusinessRequestValidator;
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
public class BusinessPeer implements BusinessService {

    private final BusinessRequestValidator validator;
    private final InternalOrderService service;

    @Override
    public CreateBusinessResponse create(CreateBusinessRequest request) throws OrdersServiceException
    {
        try{ validator.validate(request); } catch (OrdersServiceException exception) {
            return new CreateBusinessResponse(request, ResponseCode.REQUEST_INVALID, null);
        }

        Business business = service.create(request).toApi();
        return new CreateBusinessResponse(request, ResponseCode.OK, business);
    }

    @Override
    public GetBusinessResponse get(GetBusinessRequest request) throws OrdersServiceException
    {
        Long id;
        try{ id = validator.validate(request); } catch (OrdersServiceException exception) {
            return new GetBusinessResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        Business business = service.getBusinessBy(id).toApi();
        return new GetBusinessResponse(request, ResponseCode.OK, business);
    }

    @Override
    public DeleteBusinessResponse delete(DeleteBusinessRequest request)  throws OrdersServiceException
    {
        Long id;
        try{ id = validator.validate(request); } catch (OrdersServiceException exception) {
            return new DeleteBusinessResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        Business business = service.getBusinessBy(id).delete().toApi();
        return new DeleteBusinessResponse(request, ResponseCode.OK, null);
    }

    @Override
    public SearchBusinessResponse search(SearchBusinessRequest request) throws OrdersServiceException
    {
        try{ validator.validate(request); } catch (OrdersServiceException exception) {
            return new SearchBusinessResponse(request, ResponseCode.REQUEST_INVALID, null, 0,0);
        }
        List<Business> results = service.search(request).stream().map(ApiConvertible::toApi).collect(Collectors.toList());
        return new SearchBusinessResponse(
            request, ResponseCode.OK, results, request.getPageNumber(), request.getPageSize()
        );
    }

    @Override
    public UpdateBusinessResponse update(UpdateBusinessRequest request) throws OrdersServiceException
    {
        try{ validator.validate(request); } catch (OrdersServiceException exception) {
            return new UpdateBusinessResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        Business business = service.getBusinessBy(request.getId()).update(request).toApi();
        return new UpdateBusinessResponse(request, ResponseCode.OK, business);
    }
}
