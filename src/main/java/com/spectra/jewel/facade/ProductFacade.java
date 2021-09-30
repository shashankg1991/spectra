package com.spectra.jewel.facade;

import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.data.ProductVariantData;

public interface ProductFacade {
	ProductData getProductForCode(String productCode);

	ProductVariantData getVariantProductData(String productCode,
			String metalPurityCode, String metalColorCode,
			String productSizeCode, String diamondGradeCode);
}
