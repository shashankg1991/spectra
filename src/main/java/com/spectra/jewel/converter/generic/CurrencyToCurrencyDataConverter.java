package com.spectra.jewel.converter.generic;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.CurrencyData;
import com.spectra.jewel.model.enums.Currency;

@Component("currencyToCurrencyDataConverter")
public class CurrencyToCurrencyDataConverter
		extends
			PopulatingConverter<Currency, CurrencyData> {

	@Override
	public CurrencyData convert(Currency source) {
		CurrencyData target = new CurrencyData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(Currency source, CurrencyData target) {
		target.setCode(source.toString());
		target.setName(source.getSymbol());
	}

}
