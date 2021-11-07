package com.spectra.jewel.converter.generic.ws;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.ws.PriceWsData;
import com.spectra.jewel.model.Price;

@Component
public class PriceToPriceWsDataConverter
		extends
			PopulatingConverter<Price, PriceWsData> {

	@Override
	public PriceWsData convert(Price source) {
		PriceWsData target = new PriceWsData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(Price source, PriceWsData target) {
		target.setId(source.getId());
		target.setVal(source.getPriceValue());
		if (Objects.nonNull(source.getUnit())) {
			target.setUnit(source.getUnit().name());
		}
		if (Objects.nonNull(source.getCurrency())) {
			target.setCurrency(source.getCurrency().name());
		}
	}

}
