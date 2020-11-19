package com.compname.orders.core.persistence.repository;

import com.compname.orders.core.persistence.model.DbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<DbUser, Long> { }
