package com.spectra.jewel.converter;

import org.springframework.stereotype.Component;

import com.spectra.jewel.data.DiamondGradeData;
import com.spectra.jewel.model.enums.DiamondGrade;

@Component("diamondGradeToDiamondGradeDataConverter")
public class DiamondGradeToDiamondGradeDataConverter
		extends
			PopulatingConverter<DiamondGrade, DiamondGradeData> {

	@Override
	public DiamondGradeData convert(DiamondGrade source) {
		DiamondGradeData target = new DiamondGradeData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(DiamondGrade source, DiamondGradeData target) {
		target.setCode(source.toString());
		target.setName(source.getName());
	}

}
