package com.spectra.jewel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spectra.jewel.model.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
