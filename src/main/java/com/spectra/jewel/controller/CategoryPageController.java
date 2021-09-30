package com.spectra.jewel.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spectra.jewel.repository.ProductRepository;
import com.spectra.jewel.service.SolrProductService;

@Controller
@RequestMapping("/**/c")
public class CategoryPageController {
	@Resource
	ProductRepository productRepository;

	@Resource
	SolrProductService solrProductService;

	@GetMapping(value = "/{categoryCode:.*}")
	public String list(@PathVariable("categoryCode") final String categoryCode,
			Model model) {
		solrProductService.deleteAll();
		productRepository.findAll()
				.forEach(product -> solrProductService.addToIndex(product));
		model.addAttribute("searchPageResult",
				solrProductService.getProductsForCategory(categoryCode));

		return "/product/productlist";
	}

}
