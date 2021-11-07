package com.spectra.jewel.converter.generic.ws;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.ws.WeightWsData;
import com.spectra.jewel.model.Weight;

@Component
public class WeightToWeightWsDataConverter
		extends
			PopulatingConverter<Weight, WeightWsData> {

	@Override
	public WeightWsData convert(Weight source) {
		WeightWsData target = new WeightWsData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(Weight source, WeightWsData target) {
		target.setId(source.getId());
		target.setVal(source.getWeightValue());
		if (Objects.nonNull(source.getUnit())) {
			target.setUnit(source.getUnit().name());
		}
	}
}
