package com.spectra.jewel.converter;

import org.springframework.stereotype.Component;

import com.spectra.jewel.data.PriceUnitData;
import com.spectra.jewel.model.enums.PriceUnit;

@Component("priceUnitToPriceUnitDataConverter")
public class PriceUnitToPriceUnitDataConverter
		extends
			PopulatingConverter<PriceUnit, PriceUnitData> {

	@Override
	public PriceUnitData convert(PriceUnit source) {
		PriceUnitData target = new PriceUnitData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(PriceUnit source, PriceUnitData target) {
		target.setCode(source.toString());
		target.setName(source.getSymbol());
	}

}
