package com.compname.orders.api.message.request.employee;

import com.compname.orders.api.message.request.ApiIdRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateEmployeeRequest extends ApiIdRequest {

    private String name;
    private String title;
    private Set<Long> offerIds;

    public UpdateEmployeeRequest(Long id, String name, String title, Set<Long> offerIds) {
        super(id);
        this.name = name;
        this.title = title;
        this.offerIds = offerIds;
    }
}
