package com.spectra.jewel.service.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spectra.jewel.model.product.ProductImage;
import com.spectra.jewel.repository.ProducImageRepository;
import com.spectra.jewel.service.ProductImageService;

@Service("productImageService")
public class DefaultProductImageService implements ProductImageService {
	@Autowired
	ProducImageRepository producImageRepository;

	@Override
	public void delete(Collection<ProductImage> images) {
		if (CollectionUtils.isNotEmpty(images)) {
			producImageRepository.deleteByIdIn(images.stream()
					.map(ProductImage::getId).collect(Collectors.toList()));
		}
	}
}
