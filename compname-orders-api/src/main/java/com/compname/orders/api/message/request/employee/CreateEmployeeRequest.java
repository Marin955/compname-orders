package com.compname.orders.api.message.request.employee;

import com.compname.orders.api.message.request.ApiBasicEntityRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateEmployeeRequest extends ApiBasicEntityRequest {

    private String title;
    private Long businessId;
    private Set<Long> offerIds;

    public CreateEmployeeRequest(Long id, String name, String createdBy, String title, Long businessId, Set<Long> offerIds) {
        super(id, name, createdBy);
        this.title = title;
        this.businessId = businessId;
        this.offerIds = offerIds;
    }

    public CreateEmployeeRequest(String name, String createdBy, String title, Long businessId, Set<Long> offerIds) {
        super(name, createdBy);
        this.title = title;
        this.businessId = businessId;
        this.offerIds = offerIds;
    }
}
