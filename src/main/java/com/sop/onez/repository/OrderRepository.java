package com.sop.onez.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sop.onez.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	@Query(value = "SELECT * FROM ORDERS O WHERE O.CUSTOMER_ID = :id", nativeQuery=true)
	Optional<Order> findByCustomerId(@Param("id") String id);
}
