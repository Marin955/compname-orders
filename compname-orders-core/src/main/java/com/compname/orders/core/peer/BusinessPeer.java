package com.compname.orders.core.peer;

import com.compname.orders.api.message.request.business.*;
import com.compname.orders.api.message.response.ResponseCode;
import com.compname.orders.api.message.response.business.*;
import com.compname.orders.api.model.business.Address;
import com.compname.orders.api.model.business.Business;
import com.compname.orders.api.model.business.ContactInfo;
import com.compname.orders.api.model.business.Geolocation;
import com.compname.orders.api.service.BusinessService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;

@Service
@Transactional
public class BusinessPeer implements BusinessService {

    @Override
    public CreateBusinessResponse create(CreateBusinessRequest request) {
        return null;
    }

    @Override
    public GetBusinessResponse get(GetBusinessRequest request) { return null; }

    @Override
    public DeleteBusinessResponse delete(DeleteBusinessRequest request) {
        return null;
    }

    @Override
    public SearchBusinessResponse search(SearchBusinessRequest request) {
        return null;
    }

    @Override
    public UpdateBusinessResponse update(UpdateBusinessRequest request) {
        return null;
    }
}
