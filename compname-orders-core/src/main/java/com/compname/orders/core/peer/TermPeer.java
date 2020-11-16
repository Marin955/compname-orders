package com.compname.orders.core.peer;

import com.compname.orders.api.message.request.term.*;
import com.compname.orders.api.message.response.term.*;
import com.compname.orders.api.service.TermService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TermPeer implements TermService {
    @Override
    public CreateTermResponse create(CreateTermRequest request) {
        return null;
    }

    @Override
    public GetTermResponse get(GetTermRequest request) {
        return null;
    }

    @Override
    public DeleteTermResponse delete(DeleteTermRequest request) {
        return null;
    }

    @Override
    public SearchTermResponse search(SearchTermRequest request) {
        return null;
    }

    @Override
    public UpdateTermResponse update(UpdateTermRequest request) {
        return null;
    }
}
