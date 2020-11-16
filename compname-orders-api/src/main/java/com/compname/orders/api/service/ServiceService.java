package com.compname.orders.api.service;

import com.compname.orders.api.message.request.service.*;
import com.compname.orders.api.message.response.service.*;

public interface ServiceService {
    CreateServiceResponse create(CreateServiceRequest request);
    GetServiceResponse get(GetServiceRequest request);
    DeleteServiceResponse delete(DeleteServiceRequest request);
    SearchServiceResponse search(SearchServiceRequest request);
    UpdateServiceResponse update(UpdateServiceRequest request);
}
