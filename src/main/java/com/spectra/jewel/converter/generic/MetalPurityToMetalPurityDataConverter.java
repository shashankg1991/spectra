package com.spectra.jewel.converter.generic;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.MetalPurityData;
import com.spectra.jewel.model.enums.MetalPurity;

@Component("metalPurityToMetalPurityDataConverter")
public class MetalPurityToMetalPurityDataConverter
		extends
			PopulatingConverter<MetalPurity, MetalPurityData> {

	@Override
	public MetalPurityData convert(MetalPurity source) {
		MetalPurityData target = new MetalPurityData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(MetalPurity source, MetalPurityData target) {
		target.setCode(source.toString());
		target.setName(source.getName());
	}

}
