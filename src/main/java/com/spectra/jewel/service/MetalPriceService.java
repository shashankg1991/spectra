package com.spectra.jewel.service;

import com.spectra.jewel.model.enums.Currency;
import com.spectra.jewel.model.enums.MetalType;

public interface MetalPriceService {
	double getMetalUnitPriceInGram(MetalType metalType, Currency currency);
}
