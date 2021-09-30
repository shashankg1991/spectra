package com.spectra.jewel.service;

import java.util.List;

import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.product.Product;

public interface ProductService {
	Product getProductForCode(String productCode);

	Double getGrossWeight(Product product, MetalPurity metalPurity,
			ProductSize productSize);

	Double getDiamondWeight(Product product, DiamondGrade diamondGrade);

	Double getDiamondNumber(Product product, DiamondGrade diamondGrade);

	Double getStonesWeight(Product product);

	List<String> getImages(Product product, MetalColor metalColor);
}
