package com.spectra.jewel.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spectra.jewel.constants.JewelApplicationConstants;
import com.spectra.jewel.model.enums.DiamondGrade;
import com.spectra.jewel.model.enums.MetalColor;
import com.spectra.jewel.model.enums.MetalPurity;
import com.spectra.jewel.model.enums.ProductSize;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.model.product.ProductDiamondEntry;
import com.spectra.jewel.model.product.ProductDiamondGradeDetail;
import com.spectra.jewel.model.product.ProductImage;
import com.spectra.jewel.model.product.ProductMetalSizeEntry;
import com.spectra.jewel.model.product.ProductStoneEntry;
import com.spectra.jewel.model.product.StockLevel;
import com.spectra.jewel.repository.ProductRepository;
import com.spectra.jewel.repository.specification.ProductSpecification;
import com.spectra.jewel.repository.specification.ProductSearchCriteria;
import com.spectra.jewel.service.ProductDiamondEntryService;
import com.spectra.jewel.service.ProductDiamondGradeDetailService;
import com.spectra.jewel.service.ProductImageService;
import com.spectra.jewel.service.ProductMetalSizeEntryService;
import com.spectra.jewel.service.ProductService;
import com.spectra.jewel.service.ProductStoneEntryService;
import com.spectra.jewel.service.StockLevelService;
import com.spectra.jewel.service.UnitConversionService;

@Service("productService")
public class DefaultProductService implements ProductService {
	@Resource
	ProductRepository productRepository;

	@Resource
	UnitConversionService conversionService;

	@Resource
	ProductMetalSizeEntryService productMetalSizeEntryService;

	@Resource
	ProductStoneEntryService productStoneEntryService;

	@Resource
	ProductImageService productImageService;

	@Resource
	ProductDiamondEntryService productDiamondEntryService;

	@Resource
	ProductDiamondGradeDetailService productDiamondGradeDetailService;

	@Resource
	StockLevelService stockLevelService;

	@Override
	public Product getProductForCode(String productCode) {
		return productRepository.findByCode(productCode);
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
	}

	private static final int PAGE_SIZE = 5;

	@Override
	@Transactional
	public Product save(Product product) {
		Product existingProduct = getProductForCode(product.getCode());
		if (Objects.nonNull(existingProduct)) {
			if (!existingProduct.getId().equals(product.getId())) {
				throw new IllegalArgumentException(
						"Product with same code and different id already exist");
			}
			deleteRemovedMetalSizeEntries(existingProduct, product);
			deleteRemovedStoneEntries(existingProduct, product);
			deleteRemovedStocks(existingProduct, product);
			deleteRemovedImages(existingProduct, product);
			deleteRemovedProductDiamondGradeDetails(existingProduct, product);
		}

		if (CollectionUtils.isNotEmpty(product.getDiamondGradeDetails())) {
			for (ProductDiamondGradeDetail diamondGradeDetail : product
					.getDiamondGradeDetails()) {
				ProductDiamondGradeDetail existingDiamondGradeDetail = productDiamondGradeDetailService
						.getDiamondGradeDetail(diamondGradeDetail.getId());
				if (Objects.nonNull(existingDiamondGradeDetail)) {
					deleteRemovedProductDiamondEntries(
							existingDiamondGradeDetail, diamondGradeDetail);
				}

			}
		}
		return productRepository.save(product);
	}

	private void deleteRemovedMetalSizeEntries(Product existingProduct,
			Product updatedProduct) {
		if (Objects.nonNull(existingProduct.getMetalSizeEntries())) {
			List<ProductMetalSizeEntry> toDeletedMetalSizeEntries = new ArrayList<ProductMetalSizeEntry>();
			for (ProductMetalSizeEntry entry : existingProduct
					.getMetalSizeEntries()) {
				if (CollectionUtils
						.isEmpty(updatedProduct.getMetalSizeEntries())
						|| updatedProduct.getMetalSizeEntries().stream()
								.noneMatch(updatedEntry -> updatedEntry.getId()
										.equals(entry.getId()))) {
					toDeletedMetalSizeEntries.add(entry);
				}
			}
			productMetalSizeEntryService.delete(toDeletedMetalSizeEntries);
		}
	}

	private void deleteRemovedStoneEntries(Product existingProduct,
			Product updatedProduct) {
		if (Objects.nonNull(existingProduct.getStonesEntries())) {
			List<ProductStoneEntry> toDeletedStoneEntries = new ArrayList<ProductStoneEntry>();
			for (ProductStoneEntry entry : existingProduct.getStonesEntries()) {
				if (CollectionUtils.isEmpty(updatedProduct.getStonesEntries())
						|| updatedProduct.getStonesEntries().stream()
								.noneMatch(updatedEntry -> updatedEntry.getId()
										.equals(entry.getId()))) {
					toDeletedStoneEntries.add(entry);
				}
			}
			productStoneEntryService.delete(toDeletedStoneEntries);
		}
	}

	private void deleteRemovedStocks(Product existingProduct,
			Product updatedProduct) {
		if (Objects.nonNull(existingProduct.getStocks())) {
			List<StockLevel> toDeletedStocks = new ArrayList<StockLevel>();
			for (StockLevel stock : existingProduct.getStocks()) {
				if (CollectionUtils.isEmpty(updatedProduct.getStocks())
						|| updatedProduct.getStocks().stream()
								.noneMatch(updatedStock -> updatedStock.getId()
										.equals(stock.getId()))) {
					toDeletedStocks.add(stock);
				}
			}
			stockLevelService.delete(toDeletedStocks);
		}
	}

	private void deleteRemovedImages(Product existingProduct,
			Product updatedProduct) {
		if (Objects.nonNull(existingProduct.getImages())) {
			List<ProductImage> toDeletedImages = new ArrayList<ProductImage>();
			for (ProductImage image : existingProduct.getImages()) {
				if (CollectionUtils.isEmpty(updatedProduct.getImages())
						|| updatedProduct.getImages().stream()
								.noneMatch(updatedImage -> updatedImage.getId()
										.equals(image.getId()))) {
					toDeletedImages.add(image);
				}
			}
			productImageService.delete(toDeletedImages);
		}
	}

	private void deleteRemovedProductDiamondGradeDetails(
			Product existingProduct, Product updatedProduct) {
		if (Objects.nonNull(existingProduct.getDiamondGradeDetails())) {
			List<ProductDiamondGradeDetail> toDeletedDiamondGradeDetails = new ArrayList<ProductDiamondGradeDetail>();
			for (ProductDiamondGradeDetail diamondGradeDetail : existingProduct
					.getDiamondGradeDetails()) {
				if (CollectionUtils
						.isEmpty(updatedProduct.getDiamondGradeDetails())
						|| updatedProduct.getImages().stream().noneMatch(
								updatedDiamondGradeDetail -> updatedDiamondGradeDetail
										.getId()
										.equals(diamondGradeDetail.getId()))) {
					toDeletedDiamondGradeDetails.add(diamondGradeDetail);
				}
			}
			productDiamondGradeDetailService
					.delete(toDeletedDiamondGradeDetails);
		}
	}

	private void deleteRemovedProductDiamondEntries(
			ProductDiamondGradeDetail existingProductDiamondGradeDetail,
			ProductDiamondGradeDetail updatedProductDiamondGradeDetail) {
		if (Objects.nonNull(existingProductDiamondGradeDetail.getEntries())) {
			List<ProductDiamondEntry> toDeletedDiamondEntries = new ArrayList<ProductDiamondEntry>();
			for (ProductDiamondEntry diamondEntry : existingProductDiamondGradeDetail
					.getEntries()) {
				if (CollectionUtils
						.isEmpty(updatedProductDiamondGradeDetail.getEntries())
						|| updatedProductDiamondGradeDetail.getEntries()
								.stream().noneMatch(
										updatedDiamondEntry -> updatedDiamondEntry
												.getId().equals(diamondEntry
														.getId()))) {
					toDeletedDiamondEntries.add(diamondEntry);
				}
			}
			productDiamondEntryService.delete(toDeletedDiamondEntries);
		}
	}

	@Override
	public Double getGrossWeight(Product product, MetalPurity metalPurity,
			ProductSize productSize) {
		ProductMetalSizeEntry metalSizeEntry = product.getMetalSizeEntries()
				.stream()
				.filter(entry -> Objects.nonNull(entry.getPurity())
						&& Objects.nonNull(entry.getSize())
						&& Objects.nonNull(entry.getWeight())
						&& entry.getPurity().equals(metalPurity)
						&& entry.getSize().equals(productSize))
				.findFirst().orElse(null);

		return Objects.nonNull(metalSizeEntry)
				? conversionService.convert(metalSizeEntry.getWeight(),
						JewelApplicationConstants.DEFAULT_METAL_WEIGHT_UNIT)
				: null;
	}

	@Override
	public Double getDiamondWeight(Product product, DiamondGrade diamondGrade) {
		if (Objects.nonNull(diamondGrade)) {
			if (CollectionUtils.isNotEmpty(product.getDiamondGradeDetails())) {
				ProductDiamondGradeDetail diamondGradeDetail = product
						.getDiamondGradeDetails().stream()
						.filter(entry -> CollectionUtils
								.isNotEmpty(entry.getEntries())
								&& Objects.nonNull(entry.getGrade())
								&& entry.getGrade().equals(diamondGrade))
						.findFirst().orElse(null);

				if (Objects.nonNull(diamondGradeDetail)) {
					return diamondGradeDetail.getEntries().stream()
							.filter(entry -> Objects.nonNull(entry.getWeight()))
							.mapToDouble(entry -> conversionService.convert(
									entry.getWeight(),
									JewelApplicationConstants.DEFAULT_DIAMOND_WEIGHT_UNIT))
							.sum();
				}
			}
		}
		return null;
	}

	@Override
	public Double getDiamondNumber(Product product, DiamondGrade diamondGrade) {
		if (Objects.nonNull(diamondGrade)) {
			if (CollectionUtils.isNotEmpty(product.getDiamondGradeDetails())) {
				ProductDiamondGradeDetail diamondGradeDetail = product
						.getDiamondGradeDetails().stream()
						.filter(entry -> CollectionUtils
								.isNotEmpty(entry.getEntries())
								&& Objects.nonNull(entry.getGrade())
								&& entry.getGrade().equals(diamondGrade))
						.findFirst().orElse(null);

				if (Objects.nonNull(diamondGradeDetail)) {
					return diamondGradeDetail.getEntries().stream()
							.filter(entry -> Objects.nonNull(entry.getNumber()))
							.mapToDouble(entry -> entry.getNumber()).sum();
				}
			}
		}
		return null;
	}

	@Override
	public Double getStonesWeight(Product product) {
		if (CollectionUtils.isNotEmpty(product.getStonesEntries())) {
			return product.getStonesEntries().stream()
					.filter(entry -> Objects.nonNull(entry.getWeight()))
					.mapToDouble(entry -> conversionService.convert(
							entry.getWeight(),
							JewelApplicationConstants.DEFAULT_STONE_WEIGHT_UNIT))
					.sum();
		}
		return 0d;
	}

	@Override
	public List<String> getImages(Product product, MetalColor metalColor) {
		if (CollectionUtils.isNotEmpty(product.getImages())) {
			List<ProductImage> productImages = product.getImages().stream()
					.filter(image -> Objects.nonNull(image.getColor())
							&& metalColor.equals(image.getColor()))
					.collect(Collectors.toList());

			if (CollectionUtils.isEmpty(productImages)
					&& !metalColor.equals(product.getDefaultMetalColor())) {
				return getImages(product, product.getDefaultMetalColor());
			}

			Collections.sort(productImages,
					Comparator.comparing(ProductImage::getSequence));
			return productImages.stream().map(ProductImage::getUrl)
					.collect(Collectors.toList());
		}
		return Collections.emptyList();
	}

	@Override
	public Page<Product> findAll(Long id, String code, String text, int page) {
		ProductSearchCriteria criteria = new ProductSearchCriteria();
		criteria.setId(id);
		criteria.setCode(code);
		criteria.setText(text);
		ProductSpecification specification = new ProductSpecification(criteria);
		return productRepository.findAll(specification,
				PageRequest.of(page, PAGE_SIZE));
	}

}
