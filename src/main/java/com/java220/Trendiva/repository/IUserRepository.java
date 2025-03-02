package com.java220.Trendiva.repository;

import com.java220.Trendiva.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository  extends JpaRepository<User,Long> {
}
