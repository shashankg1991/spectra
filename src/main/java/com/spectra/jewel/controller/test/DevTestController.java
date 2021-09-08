package com.spectra.jewel.controller.test;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spectra.jewel.data.ProductData;
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
		productDiamondEntry1.setSize(DiamondSize.FIFTEEN_HALF_TO_SIXTEEN);
		productDiamondEntry1.setNumber(4);
		productDiamondEntry1.setWeight(100);
		productDiamondGradeDetail1.addDiamondGradeDetail(productDiamondEntry1);

		Price price1 = new Price();
		price1.setPriceValue(10.0);
		price1.setCurrency(Currency.INR);
		productDiamondEntry1.setRate(price1);

		ProductDiamondEntry productDiamondEntry2 = new ProductDiamondEntry();
		productDiamondEntry2.setSize(DiamondSize.FIFTEEN_HALF_TO_SIXTEEN);
		productDiamondEntry2.setNumber(4);
		productDiamondEntry2.setWeight(100);
		productDiamondGradeDetail1.addDiamondGradeDetail(productDiamondEntry2);

		Price price2 = new Price();
		price2.setPriceValue(12.0);
		price2.setCurrency(Currency.INR);
		productDiamondEntry2.setRate(price2);

		// Diamond detail 2
		ProductDiamondGradeDetail productDiamondGradeDetail2 = new ProductDiamondGradeDetail();
		productDiamondGradeDetail2.setGrade(DiamondGrade.SI_GH);
		productDiamondGradeDetail2
				.setEntries(new ArrayList<ProductDiamondEntry>());
		product.addDiamondGradeDetail(productDiamondGradeDetail2);

		ProductDiamondEntry productDiamondEntry3 = new ProductDiamondEntry();
		productDiamondEntry3.setSize(DiamondSize.FIFTEEN_HALF_TO_SIXTEEN);
		productDiamondEntry3.setNumber(4);
		productDiamondEntry3.setWeight(100);
		productDiamondGradeDetail2.addDiamondGradeDetail(productDiamondEntry3);

		Price price3 = new Price();
		price3.setPriceValue(10.0);
		price3.setCurrency(Currency.INR);
		productDiamondEntry3.setRate(price3);

		ProductDiamondEntry productDiamondEntry4 = new ProductDiamondEntry();
		productDiamondEntry4.setSize(DiamondSize.FIFTEEN_HALF_TO_SIXTEEN);
		productDiamondEntry4.setNumber(4);
		productDiamondEntry4.setWeight(100);
		productDiamondGradeDetail2.addDiamondGradeDetail(productDiamondEntry4);

		Price price4 = new Price();
		price4.setPriceValue(12.0);
		price4.setCurrency(Currency.INR);
		productDiamondEntry4.setRate(price4);

		/** Images **/
		// Image 1
		ProductImage image1 = new ProductImage();
		image1.setColor(MetalColor.Yellow);
		image1.setSequence(1);
		image1.setUrl("https://www.google.com");
		product.addImage(image1);

		// Image 2
		ProductImage image2 = new ProductImage();
		image2.setColor(MetalColor.Yellow);
		image2.setSequence(1);
		image2.setUrl("https://www.google.com");
		product.addImage(image2);

		/** Stone entries **/
		// Stone entry 1
		Price price5 = new Price();
		price5.setPriceValue(10.0);
		price5.setCurrency(Currency.INR);

		ProductStoneEntry productStoneEntry1 = new ProductStoneEntry();
		productStoneEntry1.setRate(price5);
		productStoneEntry1.setWeight(1.12);
		product.addStoneEntry(productStoneEntry1);

		// Stone entry 2
		Price price6 = new Price();
		price6.setPriceValue(10.0);
		price6.setCurrency(Currency.INR);

		ProductStoneEntry productStoneEntry2 = new ProductStoneEntry();
		productStoneEntry2.setRate(price6);
		productStoneEntry2.setWeight(1.12);
		product.addStoneEntry(productStoneEntry2);

		/** Gold size entries **/
		// Gold size entry 1
		ProductMetalSizeEntry productGoldSizeEntry1 = new ProductMetalSizeEntry();
		productGoldSizeEntry1.setSize(ProductSize.RING_10);
		productGoldSizeEntry1.setPurity(MetalPurity.FOURTEEN_KARAT);
		productGoldSizeEntry1.setWeight(100d);
		product.addGoldSizeEntry(productGoldSizeEntry1);

		// Gold size entry 1
		ProductMetalSizeEntry productGoldSizeEntry2 = new ProductMetalSizeEntry();
		productGoldSizeEntry2.setSize(ProductSize.RING_12);
		productGoldSizeEntry2.setPurity(MetalPurity.FOURTEEN_KARAT);
		productGoldSizeEntry2.setWeight(1.12);
		product.addGoldSizeEntry(productGoldSizeEntry2);

		/** Metal types **/
		product.setMetalType(MetalType.Gold);
		product.setColors(Arrays.asList(MetalColor.Yellow));

		/** Stocks **/
		StockLevel stock1 = new StockLevel();
		stock1.setColor(MetalColor.Yellow);
		stock1.setDiamondGrade(DiamondGrade.SI_GH);
		stock1.setSize(ProductSize.RING_10);
		stock1.setPurity(MetalPurity.FOURTEEN_KARAT);
		stock1.setQuantity(10);
		stock1.setStatus(StockLevelStatus.IN_STOCK);
		product.addStock(stock1);

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

}
