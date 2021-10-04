package com.spectra.jewel.controller.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spectra.jewel.converter.ProductWsDataToProductConverter;
import com.spectra.jewel.data.ws.ProductWsData;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.service.ProductService;

@Controller
@RequestMapping("/adminproduct")
public class AdminProductController {

	@Resource
	ProductWsDataToProductConverter productWsDataToProductConverter;

	@Resource
	ProductService productService;

	@GetMapping("/create")
	public String createProduct() {
		return "admin/product/productcreate";
	}

	@PostMapping("/create")
	@ResponseBody
	public String createNewProduct(@RequestBody ProductWsData productWsData,
			Model model) {
		Product product = productService
				.save(productWsDataToProductConverter.convert(productWsData));
		model.addAttribute("product", product);
		return "/adminproduct/detail?productCode=" + product.getCode();
	}

	@GetMapping("/detail")
	public String createNewProduct(@RequestParam String productCode,
			Model model) {
		Product product = productService.getProductForCode(productCode);
		model.addAttribute("product", product);
		return "admin/product/productadmindetail";
	}
}
