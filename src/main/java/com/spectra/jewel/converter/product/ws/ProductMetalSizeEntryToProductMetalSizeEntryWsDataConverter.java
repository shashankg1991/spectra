package com.spectra.jewel.converter.product.ws;

import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.ws.ProductMetalSizeEntryWsData;
import com.spectra.jewel.facade.generic.WeightFacade;
import com.spectra.jewel.model.product.ProductMetalSizeEntry;

@Component
public class ProductMetalSizeEntryToProductMetalSizeEntryWsDataConverter
		extends
			PopulatingConverter<ProductMetalSizeEntry, ProductMetalSizeEntryWsData> {

	@Resource
	WeightFacade weightFacade;

	@Override
	public ProductMetalSizeEntryWsData convert(ProductMetalSizeEntry source) {
		ProductMetalSizeEntryWsData target = new ProductMetalSizeEntryWsData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(ProductMetalSizeEntry source,
			ProductMetalSizeEntryWsData target) {
		target.setId(source.getId());
		if (Objects.nonNull(source.getSize())) {
			target.setSize(source.getSize().name());
		}
		if (Objects.nonNull(source.getPurity())) {
			target.setMetalPurity(source.getPurity().name());
		}
		target.setWeight(weightFacade.getWeightWsData(source.getWeight()));
	}

}
