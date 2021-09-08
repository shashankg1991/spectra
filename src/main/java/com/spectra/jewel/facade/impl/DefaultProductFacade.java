package com.spectra.jewel.facade.impl;

import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.ProductToProductDataConverter;
import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.facade.ProductFacade;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.service.ProductService;

@Component("productFacade")
public class DefaultProductFacade implements ProductFacade {
	@Resource
	ProductService productService;

	@Resource
	ProductToProductDataConverter productToProductDataConverter;

	@Override
	public ProductData getProductForCode(String productCode) {
		Product product = productService.getProductForCode(productCode);
		if (Objects.nonNull(product)) {
			return productToProductDataConverter.convert(product);
		}
		return null;
	}

}
