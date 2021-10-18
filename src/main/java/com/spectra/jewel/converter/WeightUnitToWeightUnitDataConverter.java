package com.spectra.jewel.converter;

import org.springframework.stereotype.Component;

import com.spectra.jewel.data.WeightUnitData;
import com.spectra.jewel.model.enums.WeightUnit;

@Component("weightUnitToWeightUnitDataConverter")
public class WeightUnitToWeightUnitDataConverter
		extends
			PopulatingConverter<WeightUnit, WeightUnitData> {

	@Override
	public WeightUnitData convert(WeightUnit source) {
		WeightUnitData target = new WeightUnitData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(WeightUnit source, WeightUnitData target) {
		target.setCode(source.toString());
		target.setName(source.getSymbol());
	}

}
