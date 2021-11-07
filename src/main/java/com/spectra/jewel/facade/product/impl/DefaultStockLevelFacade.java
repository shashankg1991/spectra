package com.spectra.jewel.facade.product.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.product.ws.StockLevelToStockLevelWsDataConverter;
import com.spectra.jewel.data.ws.StockLevelWsData;
import com.spectra.jewel.facade.product.StockLevelFacade;
import com.spectra.jewel.model.product.Product;

@Component("stockLevelFacade")
public class DefaultStockLevelFacade implements StockLevelFacade {

	@Resource
	private StockLevelToStockLevelWsDataConverter stockLevelToStockLevelWsDataConverter;

	@Override
	public Collection<StockLevelWsData> getStockLevelsWsData(
			final Product product) {
		return Objects.nonNull(product)
				&& CollectionUtils.isNotEmpty(product.getStocks())
						? stockLevelToStockLevelWsDataConverter
								.convertAll(product.getStocks())
						: Collections.emptySet();
	}
}
