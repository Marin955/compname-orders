package com.compname.orders.core.persistence.repository;

import com.compname.orders.core.persistence.model.DbCity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<DbCity, Long> {
    DbCity findByName(String name);
}
