package com.compname.orders.api.message.request.employee;

import com.compname.orders.api.message.request.ApiPaginationRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SearchEmployeeRequest extends ApiPaginationRequest {

    private String name;
    private Long businessId;
    private Long offerId;

    public SearchEmployeeRequest(Integer pageNumber, Integer pageSize, String name, Long businessId, Long offerId) {
        super(pageNumber, pageSize);
        this.name = name;
        this.businessId = businessId;
        this.offerId = offerId;
    }
}
