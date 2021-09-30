package com.spectra.jewel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spectra.jewel.model.product.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	Category findCategoryByCode(String code);

}
