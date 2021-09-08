package com.spectra.jewel.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spectra.jewel.facade.ProductFacade;

@Controller
@RequestMapping("/**/p")
public class ProductPageController {

	@Resource
	ProductFacade productFacade;

	@GetMapping(value = "/{productCode:.*}")
	public String productDetail(
			@PathVariable("productCode") final String productCode,
			final Model model) {
		
		model.addAttribute("product",
				productFacade.getProductForCode(productCode));

		return "product/productdetail";
	}
}
