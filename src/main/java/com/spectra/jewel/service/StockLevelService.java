package com.spectra.jewel.service;

import java.util.List;

import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.model.product.StockLevel;

public interface StockLevelService {

	StockLevel getStockLevel(Product product, MetalPurity metalPurity,
			MetalColor metalColor, DiamondGrade diamondGrade,
			ProductSize productSize);

	void delete(List<StockLevel> stocks);
}
