package com.spectra.jewel.converter.product.ws.reverse;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.ws.StockLevelWsData;
import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.enums.StockLevelStatus;
import com.spectra.jewel.model.product.StockLevel;

@Component
public class StockLevelWsDataToStockLevelConverter
		extends
			PopulatingConverter<StockLevelWsData, StockLevel> {

	@Override
	public StockLevel convert(StockLevelWsData source) {
		StockLevel target = new StockLevel();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(StockLevelWsData source, StockLevel target) {
		target.setId(source.getId());
		target.setQuantity(source.getQuantity());
		if (Objects.nonNull(source.getStockLevel())) {
			target.setStatus(StockLevelStatus.valueOf(source.getStockLevel()));
		}
		if (Objects.nonNull(source.getMetalPurity())) {
			target.setPurity(MetalPurity.valueOf(source.getMetalPurity()));
		}
		if (Objects.nonNull(source.getDiamondGrade())) {
			target.setDiamondGrade(
					DiamondGrade.valueOf(source.getDiamondGrade()));
		}
		if (Objects.nonNull(source.getMetalColor())) {
			target.setColor(MetalColor.valueOf(source.getMetalColor()));
		}
		if (Objects.nonNull(source.getSize())) {
			target.setSize(ProductSize.valueOf(source.getSize()));
		}
	}

}
