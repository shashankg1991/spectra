package com.spectra.jewel.facade.product.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import com.spectra.jewel.converter.product.ws.ProductImageToProductImageWsDataConverter;
import com.spectra.jewel.data.ws.ImageWsData;
import com.spectra.jewel.facade.product.ProductImageFacade;
import com.spectra.jewel.model.product.Product;

@Component("productImageFacade")
public class DefaultProductImageFacade implements ProductImageFacade {
	@Resource
	private ProductImageToProductImageWsDataConverter productImageToProductImageWsDataConverter;

	@Override
	public Collection<ImageWsData> getImagesWsData(Product product) {
		return Objects.nonNull(product)
				&& CollectionUtils.isNotEmpty(product.getImages())
						? productImageToProductImageWsDataConverter
								.convertAll(product.getImages())
						: Collections.emptySet();
	}
}
