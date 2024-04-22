package com.assignment.travelpackage.repository;

import com.assignment.travelpackage.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

    @Query(value = "SELECT * FROM activities", nativeQuery = true)
    List<Activity> findAll();
}
