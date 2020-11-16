package com.compname.orders.api.service;

import com.compname.orders.api.message.request.term.*;
import com.compname.orders.api.message.response.term.*;

public interface TermService {
    CreateTermResponse create(CreateTermRequest request);
    GetTermResponse get(GetTermRequest request);
    DeleteTermResponse delete(DeleteTermRequest request);
    SearchTermResponse search(SearchTermRequest request);
    UpdateTermResponse update(UpdateTermRequest request);
}
