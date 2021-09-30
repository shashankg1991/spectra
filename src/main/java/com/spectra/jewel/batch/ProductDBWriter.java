package com.spectra.jewel.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.repository.ProductRepository;

@Component
public class ProductDBWriter implements ItemWriter<Product> {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void write(List<? extends Product> products) throws Exception {
		productRepository.saveAll(products);
	}
}