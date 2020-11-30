package com.compname.orders.core.persistence.repository;

import com.compname.orders.core.persistence.model.DbWorkHour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkHourRepository extends JpaRepository<DbWorkHour, Long>, JpaSpecificationExecutor<DbWorkHour> {
}
