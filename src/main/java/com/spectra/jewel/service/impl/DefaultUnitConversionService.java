package com.spectra.jewel.service.impl;

import java.util.Objects;

import org.springframework.stereotype.Service;

import com.spectra.jewel.model.Price;
import com.spectra.jewel.model.Weight;
import com.spectra.jewel.model.enums.PriceUnit;
import com.spectra.jewel.model.enums.WeightUnit;
import com.spectra.jewel.service.UnitConversionService;

@Service("unitConversionService")
public class DefaultUnitConversionService implements UnitConversionService {
	@Override
	public Double convert(Weight weight, WeightUnit targetUnit) {
		if (Objects.isNull(weight) || Objects.isNull(weight.getWeightValue())) {
			return null;
		}
		if (Objects.isNull(weight.getUnit())
				|| weight.getUnit().equals(targetUnit)) {
			return weight.getWeightValue();
		}
		switch (weight.getUnit()) {
			case Carat :
				switch (targetUnit) {
					case Gram :
						return weight.getWeightValue() * 0.2;
					case Milligram :
						return weight.getWeightValue() * 200;
					case Ounce :
						return weight.getWeightValue() * 0.00705479;
					default :
						return weight.getWeightValue();
				}
			case Gram :
				switch (targetUnit) {
					case Carat :
						return weight.getWeightValue() * 5;
					case Milligram :
						return weight.getWeightValue() * 1000;
					case Ounce :
						return weight.getWeightValue() * 0.035274;
					default :
						return weight.getWeightValue();
				}
			case Milligram :
				switch (targetUnit) {
					case Carat :
						return weight.getWeightValue() * 0.005;
					case Gram :
						return weight.getWeightValue() * 0.001;
					case Ounce :
						return weight.getWeightValue() * 0.000035274;
					default :
						return weight.getWeightValue();
				}
			case Ounce :
				switch (targetUnit) {
					case Carat :
						return weight.getWeightValue() * 141.748;
					case Gram :
						return weight.getWeightValue() * 28.3495;
					case Milligram :
						return weight.getWeightValue() * 28349.5;
					default :
						return weight.getWeightValue();
				}
			default :
				return weight.getWeightValue();
		}
	}

	@Override
	public Double convert(Price price, PriceUnit targetUnit) {
		if (Objects.isNull(price) || Objects.isNull(price.getPriceValue())) {
			return null;
		}

		if (Objects.isNull(price.getUnit())
				|| price.getUnit().equals(targetUnit)) {
			return price.getPriceValue();
		}

		switch (price.getUnit()) {
			case Per_Carat :
				switch (targetUnit) {
					case Per_Gram :
						return price.getPriceValue() * (1.0 / 0.2);
					case Per_Milligram :
						return price.getPriceValue() * (1.0 / 200);
					case Per_Ounce :
						return price.getPriceValue() * (1.0 / 0.00705479);
					default :
						return price.getPriceValue();
				}
			case Per_Gram :
				switch (targetUnit) {
					case Per_Carat :
						return price.getPriceValue() * (1.0 / 5);
					case Per_Milligram :
						return price.getPriceValue() * (1.0 / 1000);
					case Per_Ounce :
						return price.getPriceValue() * (1.0 / 0.035274);
					default :
						return price.getPriceValue();
				}
			case Per_Milligram :
				switch (targetUnit) {
					case Per_Carat :
						return price.getPriceValue() * (1.0 / 0.005);
					case Per_Gram :
						return price.getPriceValue() * (1.0 / 0.001);
					case Per_Ounce :
						return price.getPriceValue() * (1.0 / 0.000035274);
					default :
						return price.getPriceValue();
				}
			case Per_Ounce :
				switch (targetUnit) {
					case Per_Carat :
						return price.getPriceValue() * (1.0 / 141.748);
					case Per_Gram :
						return price.getPriceValue() * (1.0 / 28.3495);
					case Per_Milligram :
						return price.getPriceValue() * (1.0 / 28349.5);
					default :
						return price.getPriceValue();
				}
			default :
				return price.getPriceValue();
		}

	}
}
