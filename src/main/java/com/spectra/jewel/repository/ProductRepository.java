package com.spectra.jewel.repository;

import org.springframework.data.repository.CrudRepository;

import com.spectra.jewel.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
