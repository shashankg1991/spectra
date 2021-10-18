package com.spectra.jewel.converter;

import org.springframework.stereotype.Component;

import com.spectra.jewel.data.DiamondSizeData;
import com.spectra.jewel.model.enums.DiamondSize;

@Component("diamondSizeToDiamondSizeDataConverter")
public class DiamondSizeToDiamondSizeDataConverter
		extends
			PopulatingConverter<DiamondSize, DiamondSizeData> {

	@Override
	public DiamondSizeData convert(DiamondSize source) {
		DiamondSizeData target = new DiamondSizeData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(DiamondSize source, DiamondSizeData target) {
		target.setCode(source.toString());
		target.setName(source.getName());
	}

}
