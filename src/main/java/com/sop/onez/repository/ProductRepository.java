package com.sop.onez.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.*;

import com.sop.onez.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
