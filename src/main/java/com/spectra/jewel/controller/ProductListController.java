package com.spectra.jewel.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spectra.jewel.model.ProductModel;
import com.spectra.jewel.repository.ProductRepository;

@Controller
@RequestMapping("/product/list")
public class ProductListController {
	@Resource
	ProductRepository productRepository;

	@GetMapping
    public String list(Model model) {
		ProductModel product = new ProductModel();
		product.setName("Product 1");
		productRepository.save(product);
		model.addAttribute("products", productRepository.findAll());
        return "/product/productlist";
    }
}
