package com.spectra.jewel.facade.product;

import java.util.Collection;

import com.spectra.jewel.data.ws.ProductDiamondGradeDetailWsData;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.model.product.ProductDiamondGradeDetail;

public interface ProductDiamondGradeDetailFacade {

	ProductDiamondGradeDetailWsData getWsProductDiamondGradeDetail(
			ProductDiamondGradeDetail diamondGradeDetail);

	Collection<ProductDiamondGradeDetailWsData> getProductDiamondGradeDetailsWsData(
			Product product);

}
