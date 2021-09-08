package com.spectra.jewel.service.impl;

import org.springframework.stereotype.Service;

import com.spectra.jewel.model.enums.MetalType;
import com.spectra.jewel.service.MetalPriceService;

@Service("metalPriceService")
public class DefaultMetalPriceService implements MetalPriceService {

	@Override
	public double getMetalUnitPrice(MetalType metalType) {
		return 5000;
	}

}
