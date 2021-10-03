package com.spectra.jewel.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spectra.jewel.data.ws.ProductWsData;

@Controller
@RequestMapping("/adminproduct")
public class AdminProductController {

	@GetMapping("/create")
	public String createProduct() {
		return "admin/product/create";
	}

	@PostMapping("/create")
	public String createNewProduct(ProductWsData productWsData) {
		return "admin/product/details";
	}
}
