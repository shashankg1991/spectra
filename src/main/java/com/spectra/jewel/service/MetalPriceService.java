package com.spectra.jewel.service;

import com.spectra.jewel.model.enums.MetalType;

public interface MetalPriceService {
	double getMetalUnitPrice(MetalType metalType);
}
