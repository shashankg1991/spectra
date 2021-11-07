package com.spectra.jewel.converter.generic.ws.reverse;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.ws.PriceWsData;
import com.spectra.jewel.model.Price;
import com.spectra.jewel.model.enums.Currency;
import com.spectra.jewel.model.enums.PriceUnit;

@Component
public class PriceWsDataToPriceConverter
		extends
			PopulatingConverter<PriceWsData, Price> {

	@Override
	public Price convert(PriceWsData source) {
		Price target = new Price();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(PriceWsData source, Price target) {
		target.setId(source.getId());
		target.setPriceValue(source.getVal());
		if (Objects.nonNull(source.getUnit())) {
			target.setUnit(PriceUnit.valueOf(source.getUnit()));
		}
		if (Objects.nonNull(source.getCurrency())) {
			target.setCurrency(Currency.valueOf(source.getCurrency()));
		}
	}

}
