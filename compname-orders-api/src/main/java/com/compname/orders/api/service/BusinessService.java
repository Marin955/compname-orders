package com.compname.orders.api.service;

import com.compname.orders.api.message.request.business.*;
import com.compname.orders.api.message.response.business.*;

public interface BusinessService {
    CreateBusinessResponse create(CreateBusinessRequest request);
    GetBusinessResponse get(GetBusinessRequest request);
    DeleteBusinessResponse delete(DeleteBusinessRequest request);
    SearchBusinessResponse search(SearchBusinessRequest request);
    UpdateBusinessResponse update(UpdateBusinessRequest request);
}
