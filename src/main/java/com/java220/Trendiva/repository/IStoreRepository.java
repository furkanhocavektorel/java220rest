package com.java220.Trendiva.repository;

import com.java220.Trendiva.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStoreRepository extends JpaRepository<Store,Long> {
}
