package com.spectra.jewel.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.product.Product;

public interface ProductService {
	Product getProductForCode(String productCode);

	Product save(Product product);

	Double getGrossWeight(Product product, MetalPurity metalPurity,
			ProductSize productSize);

	Page<Product> findAll(Long id, String code, String text, int page);

	Double getDiamondWeight(Product product, DiamondGrade diamondGrade);

	Double getDiamondNumber(Product product, DiamondGrade diamondGrade);

	Double getStonesWeight(Product product);

	List<String> getImages(Product product, MetalColor metalColor);

	void delete(Product product);

}
