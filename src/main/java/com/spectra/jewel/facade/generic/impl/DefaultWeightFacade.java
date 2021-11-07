package com.spectra.jewel.facade.generic.impl;

import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.generic.ws.WeightToWeightWsDataConverter;
import com.spectra.jewel.data.ws.WeightWsData;
import com.spectra.jewel.facade.generic.WeightFacade;
import com.spectra.jewel.model.Weight;

@Component("weightFacade")
public class DefaultWeightFacade implements WeightFacade {
	@Resource
	private WeightToWeightWsDataConverter weightToWeightWsDataConverter;

	@Override
	public WeightWsData getWeightWsData(final Weight weight) {
		return Objects.nonNull(weight)
				? weightToWeightWsDataConverter.convert(weight)
				: null;
	}
}
