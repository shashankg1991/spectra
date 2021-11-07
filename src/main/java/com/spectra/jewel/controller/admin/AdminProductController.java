package com.spectra.jewel.controller.admin;

import java.util.Arrays;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spectra.jewel.converter.generic.CurrencyToCurrencyDataConverter;
import com.spectra.jewel.converter.generic.DiamondGradeToDiamondGradeDataConverter;
import com.spectra.jewel.converter.generic.DiamondSizeToDiamondSizeDataConverter;
import com.spectra.jewel.converter.generic.MetalPurityToMetalPurityDataConverter;
import com.spectra.jewel.converter.generic.PriceUnitToPriceUnitDataConverter;
import com.spectra.jewel.converter.generic.WeightUnitToWeightUnitDataConverter;
import com.spectra.jewel.converter.product.ProductSizeToProductSizeDataConverter;
import com.spectra.jewel.converter.product.ws.ProductToProductWsDataConverter;
import com.spectra.jewel.converter.product.ws.reverse.ProductWsDataToProductConverter;
import com.spectra.jewel.data.DBSearchPageData;
import com.spectra.jewel.data.ws.ProductWsData;
import com.spectra.jewel.facade.category.CategoryFacade;
import com.spectra.jewel.facade.product.ProductFacade;
import com.spectra.jewel.facade.product.ProductStoneEntryFacade;
import com.spectra.jewel.model.enums.Currency;
import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.DiamondSize;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.MetalType;
import com.spectra.jewel.model.enums.PriceUnit;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.enums.StockLevelStatus;
import com.spectra.jewel.model.enums.WeightUnit;
import com.spectra.jewel.repository.ProductRepository;
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

	@Resource
	CurrencyToCurrencyDataConverter currencyToCurrencyDataConverter;

	@Resource
	CategoryFacade categoryFacade;

	@Resource
	ProductToProductWsDataConverter productToProductWsDataConverter;

	@Resource
	ProductStoneEntryFacade productStoneEntryFacade;

	@Resource
	ProductFacade productFacade;

	@Resource
	ProductRepository productRepository;

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
		model.addAttribute("stockLevelStatusOptions",
				Arrays.asList(StockLevelStatus.values()));
		model.addAttribute("diamondGradeOptions",
				diamondGradeToDiamondGradeDataConverter
						.convertAll(Arrays.asList(DiamondGrade.values())));
		model.addAttribute("currencyOptions", currencyToCurrencyDataConverter
				.convertAll(Arrays.asList(Currency.values())));
		model.addAttribute("categories", categoryFacade.getAllWsCategories());
		return "pages/admin/product/createedit";
	}

	@GetMapping("/find")
	public String searchProduct(@RequestParam(required = false) Long id,
			@RequestParam(required = false) String code,
			@RequestParam(required = false) String text,
			@RequestParam(defaultValue = "0") int page, Model model) {

		DBSearchPageData<ProductWsData> searchPageData = productFacade
				.findAll(id, code, text, page);

		model.addAttribute("id", id);
		model.addAttribute("code", code);
		model.addAttribute("text", text);
		model.addAttribute("page", page);
		model.addAttribute("searchPageData", searchPageData);

		if (page > 0) {
			String previousPageUrl = "/adminproduct/find?id="
					+ (Objects.nonNull(id) ? id : StringUtils.EMPTY) + "&code="
					+ (Objects.nonNull(code) ? code : StringUtils.EMPTY)
					+ "&text="
					+ (Objects.nonNull(text) ? text : StringUtils.EMPTY)
					+ "&page=" + (page - 1);
			model.addAttribute("previousPageUrl", previousPageUrl);
		}
		if (page < searchPageData.getTotalPages() - 1) {
			String nextPageUrl = "/adminproduct/find?id="
					+ (Objects.nonNull(id) ? id : StringUtils.EMPTY) + "&code="
					+ (Objects.nonNull(code) ? code : StringUtils.EMPTY)
					+ "&text="
					+ (Objects.nonNull(text) ? text : StringUtils.EMPTY)
					+ "&page=" + (page + 1);
			model.addAttribute("nextPageUrl", nextPageUrl);
		}

		return "pages/admin/product/search";
	}

	@PostMapping("/save")
	@ResponseBody
	public String saveProduct(@RequestBody ProductWsData productWsData,
			Model model) {
		productFacade.save(productWsData);
		return "/adminproduct/find?code=" + productWsData.getCode();
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
		return "/fragments/admin/product/metalentry";
	}

	@GetMapping("/fragment/stoneentry")
	public String getStoneEntryFragment(Model model) {
		model.addAttribute("weightUnitOptions",
				weightUnitToWeightUnitDataConverter
						.convertAll(Arrays.asList(WeightUnit.values())));
		model.addAttribute("priceUnitOptions", priceUnitToPriceUnitDataConverter
				.convertAll(Arrays.asList(PriceUnit.values())));
		model.addAttribute("currencyOptions", currencyToCurrencyDataConverter
				.convertAll(Arrays.asList(Currency.values())));
		return "fragments/admin/product/stoneentry";
	}

	@GetMapping("/fragment/diamondgradedetail")
	public String getDiamondGradeDetailFragment(Model model) {
		model.addAttribute("diamondGradeOptions",
				diamondGradeToDiamondGradeDataConverter
						.convertAll(Arrays.asList(DiamondGrade.values())));
		return "/fragments/admin/product/diamondgradedetail";
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
		model.addAttribute("currencyOptions", currencyToCurrencyDataConverter
				.convertAll(Arrays.asList(Currency.values())));
		return "/fragments/admin/product/diamondentry";
	}

	@GetMapping("/fragment/image")
	public String getImageFragment(Model model) {
		model.addAttribute("metalColorOptions",
				Arrays.asList(MetalColor.values()));
		return "/fragments/admin/product/image";
	}

	@GetMapping("/fragment/stock")
	public String getStockFragment(Model model) {
		model.addAttribute("stockLevelStatusOptions",
				Arrays.asList(StockLevelStatus.values()));
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
		return "/fragments/admin/product/stock";
	}

	@GetMapping("/edit/{productCode}")
	public String editProduct(@PathVariable String productCode, Model model) {

		model.addAttribute("product", productToProductWsDataConverter
				.convert(productService.getProductForCode(productCode)));
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
		model.addAttribute("stockLevelStatusOptions",
				Arrays.asList(StockLevelStatus.values()));
		model.addAttribute("sizeOptions", productSizeToProductSizeDataConverter
				.convertAll(Arrays.asList(ProductSize.values())));
		model.addAttribute("diamondGradeOptions",
				diamondGradeToDiamondGradeDataConverter
						.convertAll(Arrays.asList(DiamondGrade.values())));
		model.addAttribute("currencyOptions", currencyToCurrencyDataConverter
				.convertAll(Arrays.asList(Currency.values())));
		model.addAttribute("diamondSizeOptions",
				diamondSizeToDiamondSizeDataConverter
						.convertAll(Arrays.asList(DiamondSize.values())));
		model.addAttribute("categories", categoryFacade.getAllWsCategories());
		return "pages/admin/product/createedit";

	}

	@GetMapping("/delete/{productCode}")
	public String deleteProduct(@PathVariable String productCode) {
		productFacade.deleteProductForCode(productCode);
		return "redirect:/adminproduct/find";
	}
}
