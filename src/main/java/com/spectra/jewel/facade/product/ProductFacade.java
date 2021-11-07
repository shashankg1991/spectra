package com.spectra.jewel.facade.product;

import com.spectra.jewel.data.DBSearchPageData;
import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.data.ProductVariantData;
import com.spectra.jewel.data.ws.ProductWsData;

public interface ProductFacade {
	ProductData getProductForCode(String productCode);

	ProductWsData getAdminProductForCode(String productCode);

	ProductVariantData getVariantProductData(String productCode,
			String metalPurityCode, String metalColorCode,
			String productSizeCode, String diamondGradeCode);

	void save(ProductWsData productWsData);

	DBSearchPageData<ProductWsData> findAll(Long id, String code, String text,
			int page);

	void deleteProductForCode(String productCode);
}
