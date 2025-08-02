package com.hostel.management.dao;

import com.hostel.management.entity.Hostel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface HostelRepository extends JpaRepository<Hostel, Integer>, JpaSpecificationExecutor<Hostel> {

    @Query(value = "select distinct city from Hostel", nativeQuery = true)
    List<String> getDistinctCities();

    @Query(value = "select distinct area from Hostel where city = :city", nativeQuery = true)
    List<String> getDistinctAreas(String city);

    List<Hostel> findByCityAndArea(String city, String area);

    @EntityGraph(attributePaths = {"rooms", "amenities"})
    Optional<Hostel> findById(int id);

    Page<Hostel> findAll(Specification<Hostel> specification, Pageable pageable);
}