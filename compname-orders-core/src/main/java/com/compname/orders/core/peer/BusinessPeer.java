package com.compname.orders.core.peer;

import com.compname.orders.api.message.request.business.*;
import com.compname.orders.api.service.BusinessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BusinessPeer implements BusinessService {

    @Override
    public ResponseEntity<Object> create(CreateBusinessRequest request) {
        return new ResponseEntity<>(request.getName(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> get(GetBusinessRequest request) {
        return new ResponseEntity<>(request.getId(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> delete(DeleteBusinessRequest request) {
        return new ResponseEntity<>(request.getId(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> search(SearchBusinessRequest request) {
        return new ResponseEntity<>(request.getName(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> update(UpdateBusinessRequest request) {
        return new ResponseEntity<>(request.getName(), HttpStatus.OK);
    }
}
