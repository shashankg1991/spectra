package com.spectra.jewel.service.impl;

import org.springframework.stereotype.Service;

import com.spectra.jewel.model.enums.Currency;
import com.spectra.jewel.model.enums.MetalType;
import com.spectra.jewel.service.MetalPriceService;

@Service("metalPriceService")
public class DefaultMetalPriceService implements MetalPriceService {

	@Override
	public double getMetalUnitPriceInGram(MetalType metalType,
			Currency currency) {
		return 5000;
	}

}
