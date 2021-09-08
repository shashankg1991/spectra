package com.spectra.jewel.facade;

import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.data.ProductVariantData;
import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.ProductSize;

public interface ProductFacade {
	ProductData getProductForCode(String productCode);

	ProductVariantData getVariantProductData(String productCode,
			String metalPurityCode, String metalColorCode,
			String productSizeCode, String diamondGradeCode);
}
