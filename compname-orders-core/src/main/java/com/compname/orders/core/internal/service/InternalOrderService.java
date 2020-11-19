package com.compname.orders.core.internal.service;

import com.compname.orders.api.message.request.business.CreateBusinessRequest;
import com.compname.orders.api.message.request.business.SearchBusinessRequest;
import com.compname.orders.api.message.request.offer.CreateOfferRequest;
import com.compname.orders.api.message.request.offer.SearchOfferRequest;
import com.compname.orders.core.internal.model.InternalBusiness;
import com.compname.orders.core.internal.model.InternalOffer;
import com.compname.orders.core.persistence.repository.BusinessRepository;
import com.compname.orders.core.persistence.repository.CityRepository;
import com.compname.orders.core.persistence.repository.OfferRepository;
import com.compname.orders.core.persistence.repository.TermRepository;
import com.compname.orders.core.persistence.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class InternalOrderService {

    private static final Logger logger = LoggerFactory.getLogger(InternalOrderService.class);

    private final BusinessRepository businessRepo;
    private final CityRepository cityRepo;
    private final OfferRepository offerRepo;
    private final TermRepository termRepo;
    private final UserRepository userRepo;

    public InternalBusiness getBusinessBy(Long id) {
        return null;
    }

    public InternalBusiness create(CreateBusinessRequest request) {
        return null;
    }

    public List<InternalBusiness> search(SearchBusinessRequest request) {
        return null;
    }

    public InternalOffer create(CreateOfferRequest request) {
        return null;
    }

    public InternalOffer getOfferBy(Long id) {
        return null;
    }

    public List<InternalOffer> search(SearchOfferRequest request) {
        return null;
    }
}
