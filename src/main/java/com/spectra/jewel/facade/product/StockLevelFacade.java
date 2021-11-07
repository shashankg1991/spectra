package com.spectra.jewel.facade.product;

import java.util.Collection;

import com.spectra.jewel.data.ws.StockLevelWsData;
import com.spectra.jewel.model.product.Product;

public interface StockLevelFacade {

	Collection<StockLevelWsData> getStockLevelsWsData(Product product);

}
