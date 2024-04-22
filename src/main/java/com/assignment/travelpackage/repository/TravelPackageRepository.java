package com.assignment.travelpackage.repository;

import com.assignment.travelpackage.model.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {
    TravelPackage findById(long id);
}

