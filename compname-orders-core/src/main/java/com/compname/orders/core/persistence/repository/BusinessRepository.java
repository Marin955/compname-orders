package com.compname.orders.core.persistence.repository;

import com.compname.orders.core.persistence.model.DbBusiness;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusinessRepository extends JpaRepository<DbBusiness, Long> { }
