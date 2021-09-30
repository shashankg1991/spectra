package com.spectra.jewel.service;

import com.spectra.jewel.model.Price;
import com.spectra.jewel.model.Weight;
import com.spectra.jewel.model.enums.PriceUnit;
import com.spectra.jewel.model.enums.WeightUnit;

public interface UnitConversionService {

	Double convert(Weight weight, WeightUnit targetUnit);

	Double convert(Price price, PriceUnit targetUnit);

}
