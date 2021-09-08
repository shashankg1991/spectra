package com.spectra.jewel.facade;

import com.spectra.jewel.data.ProductData;

public interface ProductFacade {
	ProductData getProductForCode(String productCode);
}
