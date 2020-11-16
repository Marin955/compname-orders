package com.compname.orders.core.peer;

import com.compname.orders.api.message.request.service.*;
import com.compname.orders.api.message.response.service.*;
import com.compname.orders.api.service.ServiceService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ServicePeer implements ServiceService {
    @Override
    public CreateServiceResponse create(CreateServiceRequest request) {
        return null;
    }

    @Override
    public GetServiceResponse get(GetServiceRequest request) {
        return null;
    }

    @Override
    public DeleteServiceResponse delete(DeleteServiceRequest request) {
        return null;
    }

    @Override
    public SearchServiceResponse search(SearchServiceRequest request) {
        return null;
    }

    @Override
    public UpdateServiceResponse update(UpdateServiceRequest request) {
        return null;
    }
}
