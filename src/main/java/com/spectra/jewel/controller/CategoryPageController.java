package com.spectra.jewel.controller;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spectra.jewel.data.SolrSearchPageData;
import com.spectra.jewel.repository.ProductRepository;
import com.spectra.jewel.service.SolrProductService;
import com.spectra.jewel.solr.document.ProductDocument;

@Controller
@RequestMapping("/**/c")
public class CategoryPageController {
	@Resource
	ProductRepository productRepository;

	@Resource
	SolrProductService solrProductService;

	@GetMapping(value = "/{categoryCode:.*}")
	public String list(@PathVariable("categoryCode") final String categoryCode,
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "") String q,
			Model model) {
		solrProductService.deleteAll();
		productRepository.findAll()
				.forEach(product -> solrProductService.addToIndex(product));
		SolrSearchPageData<ProductDocument> searchPageResult = StringUtils
				.isEmpty(q)
						? solrProductService
								.getProductsForCategory(categoryCode, page)
						: solrProductService.getProductsForFilters(q, page);
		model.addAttribute("searchPageResult", searchPageResult);
		if (searchPageResult.getPageNumber() > 0) {
			model.addAttribute("previousPageUrl", "/c/" + categoryCode + "?q="
					+ q + "&page=" + (searchPageResult.getPageNumber() - 1));
		}
		if (searchPageResult.getPageNumber() < searchPageResult.getTotalPages()
				- 1) {
			model.addAttribute("nextPageUrl", "/c/" + categoryCode + "?q=" + q
					+ "&page=" + (searchPageResult.getPageNumber() + 1));
		}
		model.addAttribute("categoryCode", categoryCode);

		return "pages/product/categorylist";
	}

}
