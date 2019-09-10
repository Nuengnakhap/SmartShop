package com.sop.onez.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sop.onez.model.OrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
	@Query(value = "SELECT * FROM ORDER_DETAIL O WHERE O.CUSTOMER_ID = :id", nativeQuery=true)
	List<OrderDetail> findByCustomerId(@Param("id") String id);
}
