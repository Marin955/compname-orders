package com.compname.orders.api.message.response.workhour;

import com.compname.orders.api.message.request.ApiRequest;
import com.compname.orders.api.message.response.ApiPayloadResponse;
import com.compname.orders.api.model.workhour.WorkHour;
import com.compname.orders.utility.ResponseCode;

public class GetWorkHourResponse extends ApiPayloadResponse<WorkHour> {
    public GetWorkHourResponse(ApiRequest request, ResponseCode responseCode, WorkHour payload) {
        super(request, responseCode, payload);
    }
}
