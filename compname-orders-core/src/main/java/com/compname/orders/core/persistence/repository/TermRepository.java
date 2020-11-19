package com.compname.orders.core.persistence.repository;

import com.compname.orders.core.persistence.model.DbTerm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TermRepository extends JpaRepository<DbTerm, Long> { }
