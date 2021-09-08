package com.spectra.jewel.service.impl;

import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.model.product.StockLevel;
import com.spectra.jewel.service.StockLevelService;

@Service("stockLevelService")
public class DefaultStockLevelService implements StockLevelService {
	@Override
	public StockLevel getStockLevel(Product product, MetalPurity metalPurity,
			MetalColor metalColor, DiamondGrade diamondGrade,
			ProductSize productSize) {
		if (CollectionUtils.isNotEmpty(product.getStocks())) {
			return product.getStocks().stream()
					.filter(stock -> Objects.nonNull(stock.getColor())
							&& Objects.nonNull(stock.getPurity())
							&& Objects.nonNull(stock.getDiamondGrade())
							&& Objects.nonNull(stock.getSize())
							&& metalColor.equals(stock.getColor())
							&& metalPurity.equals(stock.getPurity())
							&& diamondGrade.equals(stock.getDiamondGrade())
							&& productSize.equals(stock.getSize()))
					.findAny().orElse(null);
		}
		return null;
	}
}
