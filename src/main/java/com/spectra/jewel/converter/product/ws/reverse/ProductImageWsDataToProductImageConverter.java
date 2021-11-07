package com.spectra.jewel.converter.product.ws.reverse;

import java.util.Objects;

import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.PopulatingConverter;
import com.spectra.jewel.data.ws.ImageWsData;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.product.ProductImage;

@Component
public class ProductImageWsDataToProductImageConverter
		extends
			PopulatingConverter<ImageWsData, ProductImage> {

	@Override
	public ProductImage convert(ImageWsData source) {
		ProductImage target = new ProductImage();
		populate(source, target);
		return target;
	}

	@Override
	public void populate(ImageWsData source, ProductImage target) {
		target.setId(source.getId());
		target.setSequence(source.getSequence());
		target.setUrl(source.getUrl());
		if (Objects.nonNull(source.getMetalColor())) {
			target.setColor(MetalColor.valueOf(source.getMetalColor()));
		}
	}

}
