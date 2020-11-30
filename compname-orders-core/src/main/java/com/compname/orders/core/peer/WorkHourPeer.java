package com.compname.orders.core.peer;

import com.compname.orders.api.message.request.workhour.CreateWorkHourRequest;
import com.compname.orders.api.message.request.workhour.DeleteWorkHourRequest;
import com.compname.orders.api.message.request.workhour.GetWorkHourRequest;
import com.compname.orders.api.message.request.workhour.SearchWorkHourRequest;
import com.compname.orders.api.message.request.workhour.UpdateWorkHourRequest;
import com.compname.orders.api.message.response.workhour.CreateWorkHourResponse;
import com.compname.orders.api.message.response.workhour.DeleteWorkHourResponse;
import com.compname.orders.api.message.response.workhour.GetWorkHourResponse;
import com.compname.orders.api.message.response.workhour.SearchWorkHourResponse;
import com.compname.orders.api.message.response.workhour.UpdateWorkHourResponse;
import com.compname.orders.api.model.workhour.WorkHour;
import com.compname.orders.api.service.WorkHourService;
import com.compname.orders.core.internal.common.ApiConvertible;
import com.compname.orders.core.internal.service.InternalOrderService;
import com.compname.orders.core.validation.WorkHourRequestValidator;
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
public class WorkHourPeer implements WorkHourService {

    private final InternalOrderService service;
    private final WorkHourRequestValidator validator;

    @Override
    public CreateWorkHourResponse create(CreateWorkHourRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new CreateWorkHourResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        WorkHour workhour = service.create(request).toApi();
        return new CreateWorkHourResponse(request, ResponseCode.OK, workhour);
    }

    @Override
    public GetWorkHourResponse get(GetWorkHourRequest request) {
        WorkHour workhour;
        try{
            validator.validate(request);
            workhour = service.getWorkHourBy(request.getId()).toApi();
        } catch (OrdersServiceException exception) {
            return new GetWorkHourResponse(request, ResponseCode.REQUEST_INVALID, null);
        } catch (NullPointerException nullPointerException) {
            return new GetWorkHourResponse(request, ResponseCode.ENTITY_NOT_FOUND, null);
        }
        return new GetWorkHourResponse(request, ResponseCode.OK, workhour);
    }

    @Override
    public DeleteWorkHourResponse delete(DeleteWorkHourRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new DeleteWorkHourResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        WorkHour workhour = service.getWorkHourBy(request.getId()).delete().toApi();
        return new DeleteWorkHourResponse(request, ResponseCode.OK, workhour);
    }

    @Override
    public SearchWorkHourResponse search(SearchWorkHourRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new SearchWorkHourResponse(request, ResponseCode.REQUEST_INVALID, null,0,0);
        }
        List<WorkHour> results = service.search(request).stream().map(ApiConvertible::toApi).collect(Collectors.toList());
        return new SearchWorkHourResponse(
                request, ResponseCode.OK, results, request.getPageNumber(), request.getPageSize());
    }

    @Override
    public UpdateWorkHourResponse update(UpdateWorkHourRequest request) {
        try{
            validator.validate(request);
        } catch (OrdersServiceException exception) {
            return new UpdateWorkHourResponse(request, ResponseCode.REQUEST_INVALID, null);
        }
        WorkHour workhour = service.getWorkHourBy(request.getId()).update(request).toApi();
        return new UpdateWorkHourResponse(request, ResponseCode.OK, workhour);
    }
}
