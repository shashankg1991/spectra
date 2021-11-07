package com.spectra.jewel.converter.product.ws;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.ws.ImageWsData;
import com.spectra.jewel.model.product.ProductImage;

@Component
public class ProductImageToProductImageWsDataConverter
		extends
			PopulatingConverter<ProductImage, ImageWsData> {

	@Override
	public ImageWsData convert(ProductImage source) {
		ImageWsData target = new ImageWsData();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(ProductImage source, ImageWsData target) {
		target.setId(source.getId());
		target.setSequence(source.getSequence());
		target.setUrl(source.getUrl());
		if (Objects.nonNull(source.getColor())) {
			target.setMetalColor(source.getColor().name());
		}
	}

}
