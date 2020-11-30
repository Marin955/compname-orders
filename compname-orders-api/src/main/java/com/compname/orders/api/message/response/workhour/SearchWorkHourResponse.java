package com.compname.orders.api.message.response.workhour;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPagedPayloadResponse;
import com.compname.orders.api.model.workhour.WorkHour;
import com.compname.orders.utility.ResponseCode;

import java.util.List;

public class SearchWorkHourResponse extends ApiPagedPayloadResponse<WorkHour> {
    public SearchWorkHourResponse(ApiRequest request, ResponseCode responseCode, List<WorkHour> payload, Integer pageNumber, Integer pageSize) {
        super(request, responseCode, payload, pageNumber, pageSize);
    }
}
