package com.spectra.jewel.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.spectra.jewel.data.ws.ProductWsData;
import com.spectra.jewel.model.enums.MetalType;
import com.spectra.jewel.model.product.Product;

@Component
public class ProductWsDataToProductConverter
		extends
			PopulatingConverter<ProductWsData, Product> {

	@Override
	public Product convert(ProductWsData source) {
		Product target = new Product();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(ProductWsData source, Product target) {
		target.setCode(source.getCode());
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		target.setManufacturer(source.getManufacturer());
		target.setNotes(source.getNotes());
		target.setWastage(source.getWastage());
		//target.setFixedLabor(source.getFixedLabor());
		//target.setVariableLabor(source.getVariableLabor());
		if (StringUtils.isNotEmpty(source.getMetalType())) {
			target.setMetalType(MetalType.valueOf(source.getMetalType()));
		}
	}

}
