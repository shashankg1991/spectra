package com.spectra.jewel.converter.generic.ws.reverse;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.ws.WeightWsData;
import com.spectra.jewel.model.Weight;
import com.spectra.jewel.model.enums.WeightUnit;

@Component
public class WeightWsDataToWeightConverter
		extends
			PopulatingConverter<WeightWsData, Weight> {

	@Override
	public Weight convert(WeightWsData source) {
		Weight target = new Weight();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(WeightWsData source, Weight target) {
		target.setId(source.getId());
		target.setWeightValue(source.getVal());
		if (Objects.nonNull(source.getUnit())) {
			target.setUnit(WeightUnit.valueOf(source.getUnit()));
		}
	}
}
