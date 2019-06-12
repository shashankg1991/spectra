package com.spectra.jewel.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.repository.ProductRepository;
import com.spectra.jewel.service.SolrProductService;

@Controller
@RequestMapping("/product/list")
public class ProductListController {
	@Resource
	ProductRepository productRepository;

	@Resource
	SolrProductService solrProductService;

	@GetMapping
	public String list(Model model) {

		createDummyProductAndAddToIndex(1l);
		createDummyProductAndAddToIndex(2l);
		createDummyProductAndAddToIndex(3l);
		createDummyProductAndAddToIndex(4l);
		createDummyProductAndAddToIndex(5l);
		createDummyProductAndAddToIndex(6l);
		productRepository.findAll().forEach(product -> solrProductService.addToIndex(product));
		model.addAttribute("searchPageResult", solrProductService.getAllProducts());

		return "/product/productlist";
	}

	private void createDummyProductAndAddToIndex(Long id) {
		Product product = new Product();
		product.setName("Name " + id);
		product.setDescription("Desc " + id);
		productRepository.save(product);
	}
}
