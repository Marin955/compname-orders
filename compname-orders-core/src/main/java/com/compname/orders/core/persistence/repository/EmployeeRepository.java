package com.compname.orders.core.persistence.repository;

import com.compname.orders.core.persistence.model.DbEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<DbEmployee, Long>, JpaSpecificationExecutor<DbEmployee> {
}
