package com.bharath.springweb.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bharath.springweb.entity.Product;

public interface productRepository extends JpaRepository<Product, Integer> {

}
