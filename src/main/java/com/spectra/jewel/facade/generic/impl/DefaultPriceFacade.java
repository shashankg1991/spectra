package com.spectra.jewel.facade.generic.impl;

import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.generic.ws.PriceToPriceWsDataConverter;
import com.spectra.jewel.data.ws.PriceWsData;
import com.spectra.jewel.facade.generic.PriceFacade;
import com.spectra.jewel.model.Price;

@Component("priceFacade")
public class DefaultPriceFacade implements PriceFacade {

	@Resource
	private PriceToPriceWsDataConverter priceToPriceWsDataConverter;

	@Override
	public PriceWsData getPriceWsData(final Price price) {
		return Objects.nonNull(price)
				? priceToPriceWsDataConverter.convert(price)
				: null;
	}
}
