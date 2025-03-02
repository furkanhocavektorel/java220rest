package com.java220.Trendiva.repository;

import com.java220.Trendiva.entity.Neighborhood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INeighborhoodRepository extends JpaRepository<Neighborhood,Integer> {
}
