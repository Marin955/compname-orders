package com.compname.orders.api.service;

import com.compname.orders.api.message.request.business.*;
import org.springframework.http.ResponseEntity;

public interface BusinessService {
    ResponseEntity<Object> create(CreateBusinessRequest request);
    ResponseEntity<Object> get(GetBusinessRequest request);
    ResponseEntity<Object> delete(DeleteBusinessRequest request);
    ResponseEntity<Object> search(SearchBusinessRequest request);
    ResponseEntity<Object> update(UpdateBusinessRequest request);
}
