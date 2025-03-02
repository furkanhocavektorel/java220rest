package com.java220.Trendiva.repository;

import com.java220.Trendiva.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<City,Integer> {
}
