package com.spectra.jewel.facade.product;

import java.util.Collection;

import com.spectra.jewel.data.ws.ProductMetalSizeEntryWsData;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.model.product.ProductMetalSizeEntry;

public interface ProductMetalSizeEntryFacade {

	ProductMetalSizeEntryWsData getProductMetalSizeEntryWsData(
			final ProductMetalSizeEntry productMetalSizeEntry);

	Collection<ProductMetalSizeEntryWsData> getProductMetalSizeEntriesWsData(
			final Product product);

}
