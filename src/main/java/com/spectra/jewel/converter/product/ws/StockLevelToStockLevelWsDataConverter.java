package com.spectra.jewel.converter.product.ws;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.ws.StockLevelWsData;
import com.spectra.jewel.model.product.StockLevel;

@Component
public class StockLevelToStockLevelWsDataConverter
		extends
			PopulatingConverter<StockLevel, StockLevelWsData> {

	@Override
	public StockLevelWsData convert(StockLevel source) {
		StockLevelWsData target = new StockLevelWsData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(StockLevel source, StockLevelWsData target) {
		target.setId(source.getId());
		target.setQuantity(source.getQuantity());
		if (Objects.nonNull(source.getStatus())) {
			target.setStockLevel(source.getStatus().name());
		}
		if (Objects.nonNull(source.getPurity())) {
			target.setMetalPurity(source.getPurity().name());
		}
		if (Objects.nonNull(source.getDiamondGrade())) {
			target.setDiamondGrade(source.getDiamondGrade().name());
		}
		if (Objects.nonNull(source.getColor())) {
			target.setMetalColor(source.getColor().name());
		}
		if (Objects.nonNull(source.getSize())) {
			target.setSize(source.getSize().name());
		}
	}

}
