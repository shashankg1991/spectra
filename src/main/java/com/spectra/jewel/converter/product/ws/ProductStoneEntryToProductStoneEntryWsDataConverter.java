package com.spectra.jewel.converter.product.ws;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.ws.ProductStoneEntryWsData;
import com.spectra.jewel.facade.generic.PriceFacade;
import com.spectra.jewel.facade.generic.WeightFacade;
import com.spectra.jewel.model.product.ProductStoneEntry;

@Component
public class ProductStoneEntryToProductStoneEntryWsDataConverter
		extends
			PopulatingConverter<ProductStoneEntry, ProductStoneEntryWsData> {

	@Resource
	private PriceFacade priceFacade;

	@Resource
	private WeightFacade weightFacade;

	@Override
	public ProductStoneEntryWsData convert(final ProductStoneEntry source) {
		ProductStoneEntryWsData target = new ProductStoneEntryWsData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(final ProductStoneEntry source,
			ProductStoneEntryWsData target) {
		target.setId(source.getId());
		target.setDescription(source.getDescription());
		target.setRate(priceFacade.getPriceWsData(source.getRate()));
		target.setWeight(weightFacade.getWeightWsData(source.getWeight()));
	}
}
