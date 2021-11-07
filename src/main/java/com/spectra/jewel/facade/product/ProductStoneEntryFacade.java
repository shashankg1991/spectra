package com.spectra.jewel.facade.product;

import java.util.Collection;

import com.spectra.jewel.data.ws.ProductStoneEntryWsData;
import com.spectra.jewel.model.product.Product;

public interface ProductStoneEntryFacade {

	Collection<ProductStoneEntryWsData> getStoneEntriesWsData(Product product);

}
