package com.spectra.jewel.controller;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spectra.jewel.data.ProductVariantData;
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

	@GetMapping(value = "/{productCode:.*}/variant")
	public ResponseEntity<ProductVariantData> productVariantDetail(
			@PathVariable("productCode") final String productCode,
			@RequestParam String metalPurity, @RequestParam String metalColor,
			@RequestParam String productSize,
			@RequestParam String diamondGrade) {
		return new ResponseEntity<ProductVariantData>(
				productFacade.getVariantProductData(productCode, metalPurity,
						metalColor, productSize, diamondGrade),
				HttpStatus.ACCEPTED);
	}

}
