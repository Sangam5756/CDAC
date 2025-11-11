package com.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.core.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
		
}
