package com.compname.orders.core.persistence.repository;

import com.compname.orders.core.persistence.model.DbAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<DbAccount, Long> { }
