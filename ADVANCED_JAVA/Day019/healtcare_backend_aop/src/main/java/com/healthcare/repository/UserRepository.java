package com.healthcare.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
//derived query - findBy
	Optional<User>  findByEmailAndPassword(String em, String pass);
	//check for dup email
	boolean existsByEmail(String email);
}
