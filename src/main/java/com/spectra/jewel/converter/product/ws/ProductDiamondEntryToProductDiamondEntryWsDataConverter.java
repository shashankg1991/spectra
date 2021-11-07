package com.spectra.jewel.converter.product.ws;

import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.ws.ProductDiamondEntryWsData;
import com.spectra.jewel.facade.generic.PriceFacade;
import com.spectra.jewel.facade.generic.WeightFacade;
import com.spectra.jewel.model.product.ProductDiamondEntry;

@Component
public class ProductDiamondEntryToProductDiamondEntryWsDataConverter
		extends
			PopulatingConverter<ProductDiamondEntry, ProductDiamondEntryWsData> {

	@Resource
	private PriceFacade priceFacade;

	@Resource
	private WeightFacade weightFacade;

	@Override
	public ProductDiamondEntryWsData convert(ProductDiamondEntry source) {
		ProductDiamondEntryWsData target = new ProductDiamondEntryWsData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(ProductDiamondEntry source,
			ProductDiamondEntryWsData target) {
		target.setId(source.getId());
		target.setNumber(source.getNumber());
		if (Objects.nonNull(source.getSize())) {
			target.setSize(source.getSize().getName());
		}
		target.setRate(priceFacade.getPriceWsData(source.getRate()));
		target.setWeight(weightFacade.getWeightWsData(source.getWeight()));
	}

}
