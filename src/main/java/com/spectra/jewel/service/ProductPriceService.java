package com.spectra.jewel.service;

import com.spectra.jewel.data.PriceData;
import com.spectra.jewel.exception.PriceException;
import com.spectra.jewel.model.enums.Currency;
import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.product.Product;

public interface ProductPriceService {

	PriceData getPrice(Product product, Currency currency,
			MetalPurity metalPurity, DiamondGrade diamondGrade,
			ProductSize productSize) throws PriceException;

}
