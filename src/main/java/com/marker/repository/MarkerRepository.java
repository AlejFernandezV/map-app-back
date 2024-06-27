package com.marker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marker.models.MarkerEntity;

@Repository
public interface MarkerRepository extends JpaRepository<MarkerEntity,Long>{
    
}
