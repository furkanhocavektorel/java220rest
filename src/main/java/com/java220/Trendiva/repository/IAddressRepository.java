package com.java220.Trendiva.repository;

import com.java220.Trendiva.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address,Long> {
}
