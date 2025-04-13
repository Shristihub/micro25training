package com.cartinfo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cartinfo.model.Cart;

@Repository
public interface ICartRepository extends JpaRepository<Cart, Integer> {
	Optional<Cart> findByUserId(int userId);
}
