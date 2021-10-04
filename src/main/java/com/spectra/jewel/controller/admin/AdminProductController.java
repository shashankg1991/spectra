package com.spectra.jewel.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spectra.jewel.data.ws.ProductWsData;

@Controller
@RequestMapping("/adminproduct")
public class AdminProductController {

	@GetMapping("/create")
	public String createProduct() {
		return "admin/product/productcreate";
	}

	@PostMapping("/create")
	public String createNewProduct(@RequestBody ProductWsData productWsData) {
		return "admin/product/productadmindetail";
	}
}
