package com.spectra.jewel.repository;

import org.springframework.data.repository.CrudRepository;

import com.spectra.jewel.model.ProductModel;

public interface ProductRepository extends CrudRepository<ProductModel, Long> {

}
