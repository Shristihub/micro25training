package com.userinfo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userinfo.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findByEmail(String email);
}
