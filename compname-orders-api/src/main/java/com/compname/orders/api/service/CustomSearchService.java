package com.compname.orders.api.service;

import com.compname.orders.api.message.request.custom.SearchTermByOfferAndTimeRequest;
import com.compname.orders.api.message.response.custom.SearchByOfferAndTimeResponse;

public interface CustomSearchService {
    SearchByOfferAndTimeResponse findByOfferAndTime(SearchTermByOfferAndTimeRequest request);
}
