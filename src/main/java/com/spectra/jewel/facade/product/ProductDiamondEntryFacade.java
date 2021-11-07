package com.spectra.jewel.facade.product;

import java.util.Collection;

import com.spectra.jewel.data.ws.ProductDiamondEntryWsData;
import com.spectra.jewel.model.product.ProductDiamondGradeDetail;

public interface ProductDiamondEntryFacade {

	Collection<ProductDiamondEntryWsData> getDiamondEntriesWsData(
			ProductDiamondGradeDetail diamondGradeDetail);

}
