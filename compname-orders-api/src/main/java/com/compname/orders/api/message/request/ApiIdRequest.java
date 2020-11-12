package com.compname.orders.api.message.request;

public abstract class ApiIdRequest {

    private Long id;

    public ApiIdRequest() {}

    public ApiIdRequest(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
