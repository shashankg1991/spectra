package com.spectra.jewel.controller.admin;

import java.util.Arrays;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spectra.jewel.converter.DiamondGradeToDiamondGradeDataConverter;
import com.spectra.jewel.converter.DiamondSizeToDiamondSizeDataConverter;
import com.spectra.jewel.converter.MetalPurityToMetalPurityDataConverter;
import com.spectra.jewel.converter.PriceUnitToPriceUnitDataConverter;
import com.spectra.jewel.converter.ProductSizeToProductSizeDataConverter;
import com.spectra.jewel.converter.ProductWsDataToProductConverter;
import com.spectra.jewel.converter.WeightUnitToWeightUnitDataConverter;
import com.spectra.jewel.data.ws.ProductWsData;
import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.DiamondSize;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.MetalType;
import com.spectra.jewel.model.enums.PriceUnit;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.enums.WeightUnit;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.service.ProductService;

@Controller
@RequestMapping("/adminproduct")
public class AdminProductController {

	@Resource
	ProductWsDataToProductConverter productWsDataToProductConverter;

	@Resource
	ProductService productService;

	@Resource
	ProductSizeToProductSizeDataConverter productSizeToProductSizeDataConverter;

	@Resource
	MetalPurityToMetalPurityDataConverter metalPurityToMetalPurityDataConverter;

	@Resource
	WeightUnitToWeightUnitDataConverter weightUnitToWeightUnitDataConverter;

	@Resource
	PriceUnitToPriceUnitDataConverter priceUnitToPriceUnitDataConverter;

	@Resource
	DiamondGradeToDiamondGradeDataConverter diamondGradeToDiamondGradeDataConverter;

	@Resource
	DiamondSizeToDiamondSizeDataConverter diamondSizeToDiamondSizeDataConverter;

	@GetMapping("/create")
	public String createProduct(Model model) {
		model.addAttribute("priceUnitOptions", priceUnitToPriceUnitDataConverter
				.convertAll(Arrays.asList(PriceUnit.values())));
		model.addAttribute("weightUnitOptions",
				weightUnitToWeightUnitDataConverter
						.convertAll(Arrays.asList(WeightUnit.values())));
		model.addAttribute("metalTypeOptions",
				Arrays.asList(MetalType.values()));
		model.addAttribute("metalColorOptions",
				Arrays.asList(MetalColor.values()));
		model.addAttribute("metalPurityOptions",
				metalPurityToMetalPurityDataConverter
						.convertAll(Arrays.asList(MetalPurity.values())));
		model.addAttribute("sizeOptions", productSizeToProductSizeDataConverter
				.convertAll(Arrays.asList(ProductSize.values())));
		model.addAttribute("diamondGradeOptions",
				diamondGradeToDiamondGradeDataConverter
						.convertAll(Arrays.asList(DiamondGrade.values())));
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

	@GetMapping("/fragment/metalentry")
	public String getMetalEntryFragment(Model model) {
		model.addAttribute("weightUnitOptions",
				weightUnitToWeightUnitDataConverter
						.convertAll(Arrays.asList(WeightUnit.values())));
		model.addAttribute("metalPurityOptions",
				metalPurityToMetalPurityDataConverter
						.convertAll(Arrays.asList(MetalPurity.values())));
		model.addAttribute("sizeOptions", productSizeToProductSizeDataConverter
				.convertAll(Arrays.asList(ProductSize.values())));
		return "/admin/fragments/productmetalentry";
	}

	@GetMapping("/fragment/stoneentry")
	public String getStoneEntryFragment(Model model) {
		model.addAttribute("weightUnitOptions",
				weightUnitToWeightUnitDataConverter
						.convertAll(Arrays.asList(WeightUnit.values())));
		model.addAttribute("priceUnitOptions", priceUnitToPriceUnitDataConverter
				.convertAll(Arrays.asList(PriceUnit.values())));
		return "/admin/fragments/productstoneentry";
	}

	@GetMapping("/fragment/diamondgradedetail")
	public String getDiamondGradeDetailFragment(Model model) {
		model.addAttribute("diamondGradeOptions",
				diamondGradeToDiamondGradeDataConverter
						.convertAll(Arrays.asList(DiamondGrade.values())));
		return "/admin/fragments/productdiamondgradedetail";
	}

	@GetMapping("/fragment/diamondentry")
	public String getDiamondEntryFragment(Model model) {
		model.addAttribute("diamondSizeOptions",
				diamondSizeToDiamondSizeDataConverter
						.convertAll(Arrays.asList(DiamondSize.values())));
		model.addAttribute("weightUnitOptions",
				weightUnitToWeightUnitDataConverter
						.convertAll(Arrays.asList(WeightUnit.values())));
		model.addAttribute("priceUnitOptions", priceUnitToPriceUnitDataConverter
				.convertAll(Arrays.asList(PriceUnit.values())));
		return "/admin/fragments/productdiamondentry";
	}
}
