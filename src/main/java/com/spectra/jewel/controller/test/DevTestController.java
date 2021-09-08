package com.spectra.jewel.controller.test;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spectra.jewel.data.ProductData;
import com.spectra.jewel.data.ProductVariantData;
import com.spectra.jewel.facade.ProductFacade;
import com.spectra.jewel.model.Price;
import com.spectra.jewel.model.enums.Currency;
import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.DiamondSize;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.MetalType;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.enums.StockLevelStatus;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.model.product.ProductDiamondEntry;
import com.spectra.jewel.model.product.ProductDiamondGradeDetail;
import com.spectra.jewel.model.product.ProductImage;
import com.spectra.jewel.model.product.ProductMetalSizeEntry;
import com.spectra.jewel.model.product.ProductStoneEntry;
import com.spectra.jewel.model.product.StockLevel;
import com.spectra.jewel.repository.ProductRepository;

@RestController
@RequestMapping("/test")
public class DevTestController {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	ProductFacade productFacade;

	@GetMapping("/product/create")
	public void createProductFull() {
		Product product = new Product();
		product.setCode("P1");
		product.setDescription("Test product 1");
		product.setManufacturer("Test manufacturer");
		product.setWastage(10d);
		product.setFixedLabor(1000d);
		product.setVariableLabor(100d);
		product.setName("Test product");
		product.setNotes("Test notes");
		product.setDiamondGradeDetails(
				new ArrayList<ProductDiamondGradeDetail>());

		/** Diamond details **/
		// Diamond detail 1
		ProductDiamondGradeDetail productDiamondGradeDetail1 = new ProductDiamondGradeDetail();
		productDiamondGradeDetail1.setGrade(DiamondGrade.SI_IJ);
		productDiamondGradeDetail1
				.setEntries(new ArrayList<ProductDiamondEntry>());
		product.addDiamondGradeDetail(productDiamondGradeDetail1);

		ProductDiamondEntry productDiamondEntry1 = new ProductDiamondEntry();
		productDiamondEntry1.setSize(DiamondSize.FIVE_HALF_TO_SIX);
		productDiamondEntry1.setNumber(20);
		productDiamondEntry1.setWeight(0.65);
		productDiamondGradeDetail1.addDiamondGradeDetail(productDiamondEntry1);

		Price price1 = new Price();
		price1.setPriceValue(11000.0);
		price1.setCurrency(Currency.INR);
		productDiamondEntry1.setRate(price1);

		ProductDiamondEntry productDiamondEntry2 = new ProductDiamondEntry();
		productDiamondEntry2.setSize(DiamondSize.FIFTEEN_HALF_TO_SIXTEEN);
		productDiamondEntry2.setNumber(4);
		productDiamondEntry2.setWeight(0.12);
		productDiamondGradeDetail1.addDiamondGradeDetail(productDiamondEntry2);

		Price price2 = new Price();
		price2.setPriceValue(18000.0);
		price2.setCurrency(Currency.INR);
		productDiamondEntry2.setRate(price2);

		// Diamond detail 2
		ProductDiamondGradeDetail productDiamondGradeDetail2 = new ProductDiamondGradeDetail();
		productDiamondGradeDetail2.setGrade(DiamondGrade.SI_GH);
		productDiamondGradeDetail2
				.setEntries(new ArrayList<ProductDiamondEntry>());
		product.addDiamondGradeDetail(productDiamondGradeDetail2);

		ProductDiamondEntry productDiamondEntry3 = new ProductDiamondEntry();
		productDiamondEntry3.setSize(DiamondSize.FIVE_HALF_TO_SIX);
		productDiamondEntry3.setNumber(20);
		productDiamondEntry3.setWeight(0.64);
		productDiamondGradeDetail2.addDiamondGradeDetail(productDiamondEntry3);

		Price price3 = new Price();
		price3.setPriceValue(14000.0);
		price3.setCurrency(Currency.INR);
		productDiamondEntry3.setRate(price3);

		ProductDiamondEntry productDiamondEntry4 = new ProductDiamondEntry();
		productDiamondEntry4.setSize(DiamondSize.FIFTEEN_HALF_TO_SIXTEEN);
		productDiamondEntry4.setNumber(4);
		productDiamondEntry4.setWeight(0.13);
		productDiamondGradeDetail2.addDiamondGradeDetail(productDiamondEntry4);

		Price price4 = new Price();
		price4.setPriceValue(22000.0);
		price4.setCurrency(Currency.INR);
		productDiamondEntry4.setRate(price4);

		/** Images **/
		// Image 1
		ProductImage image1 = new ProductImage();
		image1.setColor(MetalColor.Yellow);
		image1.setSequence(1);
		image1.setUrl(
				"https://www.peoplesjewellers.com/productimages/processed/V-19907724_0_800.jpg");
		product.addImage(image1);

		// Image 2
		ProductImage image2 = new ProductImage();
		image2.setColor(MetalColor.Yellow);
		image2.setSequence(1);
		image2.setUrl(
				"https://www.peoplesjewellers.com/productimages/processed/V-19907724_1_800.jpg");
		product.addImage(image2);

		/** Stone entries **/
		// Stone entry 1
		Price price5 = new Price();
		price5.setPriceValue(500.0); // This is total value and not per gm or ct
		price5.setCurrency(Currency.INR);

		ProductStoneEntry productStoneEntry1 = new ProductStoneEntry();
		productStoneEntry1.setRate(price5);
		productStoneEntry1.setWeight(50); // mg
		product.addStoneEntry(productStoneEntry1);

		// Stone entry 2
		Price price6 = new Price();
		price6.setPriceValue(800.0); // This is total value and not per gm or ct
		price6.setCurrency(Currency.INR);

		ProductStoneEntry productStoneEntry2 = new ProductStoneEntry();
		productStoneEntry2.setRate(price6);
		productStoneEntry2.setWeight(1020); // mg
		product.addStoneEntry(productStoneEntry2);

		/** Gold size entries **/
		ProductMetalSizeEntry productGoldSizeEntry1 = new ProductMetalSizeEntry();
		productGoldSizeEntry1.setSize(ProductSize.RING_6);
		productGoldSizeEntry1.setPurity(MetalPurity.FOURTEEN_KARAT);
		productGoldSizeEntry1.setWeight(3.26);
		product.addGoldSizeEntry(productGoldSizeEntry1);

		ProductMetalSizeEntry productGoldSizeEntry2 = new ProductMetalSizeEntry();
		productGoldSizeEntry2.setSize(ProductSize.RING_7);
		productGoldSizeEntry2.setPurity(MetalPurity.FOURTEEN_KARAT);
		productGoldSizeEntry2.setWeight(3.44);
		product.addGoldSizeEntry(productGoldSizeEntry2);

		ProductMetalSizeEntry productGoldSizeEntry3 = new ProductMetalSizeEntry();
		productGoldSizeEntry3.setSize(ProductSize.RING_8);
		productGoldSizeEntry3.setPurity(MetalPurity.FOURTEEN_KARAT);
		productGoldSizeEntry3.setWeight(3.48);
		product.addGoldSizeEntry(productGoldSizeEntry3);

		ProductMetalSizeEntry productGoldSizeEntry4 = new ProductMetalSizeEntry();
		productGoldSizeEntry4.setSize(ProductSize.RING_9);
		productGoldSizeEntry4.setPurity(MetalPurity.FOURTEEN_KARAT);
		productGoldSizeEntry4.setWeight(3.50);
		product.addGoldSizeEntry(productGoldSizeEntry4);

		ProductMetalSizeEntry productGoldSizeEntry5 = new ProductMetalSizeEntry();
		productGoldSizeEntry5.setSize(ProductSize.RING_10);
		productGoldSizeEntry5.setPurity(MetalPurity.FOURTEEN_KARAT);
		productGoldSizeEntry5.setWeight(3.59);
		product.addGoldSizeEntry(productGoldSizeEntry5);

		ProductMetalSizeEntry productGoldSizeEntry6 = new ProductMetalSizeEntry();
		productGoldSizeEntry6.setSize(ProductSize.RING_11);
		productGoldSizeEntry6.setPurity(MetalPurity.FOURTEEN_KARAT);
		productGoldSizeEntry6.setWeight(3.67);
		product.addGoldSizeEntry(productGoldSizeEntry6);

		ProductMetalSizeEntry productGoldSizeEntry7 = new ProductMetalSizeEntry();
		productGoldSizeEntry7.setSize(ProductSize.RING_12);
		productGoldSizeEntry7.setPurity(MetalPurity.FOURTEEN_KARAT);
		productGoldSizeEntry7.setWeight(3.75);
		product.addGoldSizeEntry(productGoldSizeEntry7);

		/** Metal types **/
		product.setMetalType(MetalType.Gold);
		product.setColors(Arrays.asList(MetalColor.Yellow, MetalColor.White));

		/** Stocks **/
		StockLevel stock1 = new StockLevel();
		stock1.setColor(MetalColor.Yellow);
		stock1.setDiamondGrade(DiamondGrade.SI_IJ);
		stock1.setSize(ProductSize.RING_6);
		stock1.setPurity(MetalPurity.FOURTEEN_KARAT);
		stock1.setQuantity(10);
		stock1.setStatus(StockLevelStatus.IN_STOCK);
		product.addStock(stock1);

		StockLevel stock2 = new StockLevel();
		stock2.setColor(MetalColor.Yellow);
		stock2.setDiamondGrade(DiamondGrade.SI_IJ);
		stock2.setSize(ProductSize.RING_7);
		stock2.setPurity(MetalPurity.FOURTEEN_KARAT);
		stock2.setQuantity(10);
		stock2.setStatus(StockLevelStatus.IN_STOCK);
		product.addStock(stock2);

		StockLevel stock3 = new StockLevel();
		stock3.setColor(MetalColor.Yellow);
		stock3.setDiamondGrade(DiamondGrade.SI_IJ);
		stock3.setSize(ProductSize.RING_8);
		stock3.setPurity(MetalPurity.FOURTEEN_KARAT);
		stock3.setQuantity(10);
		stock3.setStatus(StockLevelStatus.IN_STOCK);
		product.addStock(stock3);

		StockLevel stock4 = new StockLevel();
		stock4.setColor(MetalColor.Yellow);
		stock4.setDiamondGrade(DiamondGrade.SI_IJ);
		stock4.setSize(ProductSize.RING_9);
		stock4.setPurity(MetalPurity.FOURTEEN_KARAT);
		stock4.setQuantity(10);
		stock4.setStatus(StockLevelStatus.IN_STOCK);
		product.addStock(stock4);

		StockLevel stock5 = new StockLevel();
		stock5.setColor(MetalColor.Yellow);
		stock5.setDiamondGrade(DiamondGrade.SI_IJ);
		stock5.setSize(ProductSize.RING_10);
		stock5.setPurity(MetalPurity.FOURTEEN_KARAT);
		stock5.setQuantity(10);
		stock5.setStatus(StockLevelStatus.IN_STOCK);
		product.addStock(stock5);

		StockLevel stock6 = new StockLevel();
		stock6.setColor(MetalColor.Yellow);
		stock6.setDiamondGrade(DiamondGrade.SI_IJ);
		stock6.setSize(ProductSize.RING_11);
		stock6.setPurity(MetalPurity.FOURTEEN_KARAT);
		stock6.setQuantity(10);
		stock6.setStatus(StockLevelStatus.IN_STOCK);
		product.addStock(stock6);

		StockLevel stock7 = new StockLevel();
		stock7.setColor(MetalColor.Yellow);
		stock7.setDiamondGrade(DiamondGrade.SI_IJ);
		stock7.setSize(ProductSize.RING_12);
		stock7.setPurity(MetalPurity.FOURTEEN_KARAT);
		stock7.setQuantity(10);
		stock7.setStatus(StockLevelStatus.IN_STOCK);
		product.addStock(stock7);

		StockLevel stock8 = new StockLevel();
		stock8.setColor(MetalColor.Yellow);
		stock8.setDiamondGrade(DiamondGrade.SI_GH);
		stock8.setSize(ProductSize.RING_6);
		stock8.setPurity(MetalPurity.FOURTEEN_KARAT);
		stock8.setQuantity(10);
		stock8.setStatus(StockLevelStatus.IN_STOCK);
		product.addStock(stock8);

		StockLevel stock9 = new StockLevel();
		stock9.setColor(MetalColor.Yellow);
		stock9.setDiamondGrade(DiamondGrade.SI_GH);
		stock9.setSize(ProductSize.RING_7);
		stock9.setPurity(MetalPurity.FOURTEEN_KARAT);
		stock9.setQuantity(10);
		stock9.setStatus(StockLevelStatus.IN_STOCK);
		product.addStock(stock9);

		StockLevel stock10 = new StockLevel();
		stock10.setColor(MetalColor.Yellow);
		stock10.setDiamondGrade(DiamondGrade.SI_GH);
		stock10.setSize(ProductSize.RING_8);
		stock10.setPurity(MetalPurity.FOURTEEN_KARAT);
		stock10.setQuantity(10);
		stock10.setStatus(StockLevelStatus.IN_STOCK);
		product.addStock(stock10);

		StockLevel stock11 = new StockLevel();
		stock11.setColor(MetalColor.Yellow);
		stock11.setDiamondGrade(DiamondGrade.SI_GH);
		stock11.setSize(ProductSize.RING_9);
		stock11.setPurity(MetalPurity.FOURTEEN_KARAT);
		stock11.setQuantity(10);
		stock11.setStatus(StockLevelStatus.IN_STOCK);
		product.addStock(stock11);

		StockLevel stock12 = new StockLevel();
		stock12.setColor(MetalColor.Yellow);
		stock12.setDiamondGrade(DiamondGrade.SI_GH);
		stock12.setSize(ProductSize.RING_10);
		stock12.setPurity(MetalPurity.FOURTEEN_KARAT);
		stock12.setQuantity(10);
		stock12.setStatus(StockLevelStatus.IN_STOCK);
		product.addStock(stock12);

		StockLevel stock13 = new StockLevel();
		stock13.setColor(MetalColor.Yellow);
		stock13.setDiamondGrade(DiamondGrade.SI_GH);
		stock13.setSize(ProductSize.RING_11);
		stock13.setPurity(MetalPurity.FOURTEEN_KARAT);
		stock13.setQuantity(10);
		stock13.setStatus(StockLevelStatus.IN_STOCK);
		product.addStock(stock13);

		StockLevel stock14 = new StockLevel();
		stock14.setColor(MetalColor.Yellow);
		stock14.setDiamondGrade(DiamondGrade.SI_GH);
		stock14.setSize(ProductSize.RING_12);
		stock14.setPurity(MetalPurity.FOURTEEN_KARAT);
		stock14.setQuantity(10);
		stock14.setStatus(StockLevelStatus.IN_STOCK);
		product.addStock(stock14);

		/** Default variant **/
		product.setDefaultMetalPurity(MetalPurity.FOURTEEN_KARAT);
		product.setDefaultMetalColor(MetalColor.Yellow);
		product.setDefaultProductSize(ProductSize.RING_10);
		product.setDefaultDiamondGrade(DiamondGrade.SI_GH);

		productRepository.save(product);
	}

	@GetMapping("/product/{code}")
	public ProductData getProduct(@PathVariable String code) {
		return productFacade.getProductForCode(code);
	}

	@GetMapping("/productvariant/{code}")
	public ProductVariantData getProductVariant(@PathVariable String code,
			@RequestParam String metalPurity, @RequestParam String metalColor,
			@RequestParam String productSize,
			@RequestParam String diamondGrade) {
		return productFacade.getVariantProductData(code, metalPurity,
				metalColor, productSize, diamondGrade);
	}

}
