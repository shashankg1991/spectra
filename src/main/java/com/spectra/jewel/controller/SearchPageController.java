package com.spectra.jewel.controller;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spectra.jewel.data.SearchPageData;
import com.spectra.jewel.repository.ProductRepository;
import com.spectra.jewel.service.SolrProductService;
import com.spectra.jewel.solr.document.ProductDocument;

@Controller
@RequestMapping("/**/search")
public class SearchPageController {
	@Resource
	ProductRepository productRepository;

	@Resource
	SolrProductService solrProductService;

	@GetMapping("/")
	public String list(@RequestParam(required = true) String searchTerm,
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "") String q,
			Model model) {
		solrProductService.deleteAll();
		productRepository.findAll()
				.forEach(product -> solrProductService.addToIndex(product));
		SearchPageData<ProductDocument> searchPageResult = StringUtils
				.isEmpty(q)
						? solrProductService.findBySearchTerm(searchTerm, page)
						: solrProductService.findBySearchTermAndFilters(
								searchTerm, q, page);
		model.addAttribute("searchPageResult", searchPageResult);
		if (searchPageResult.getPageNumber() > 0) {
			model.addAttribute("previousPageUrl",
					"/search?searchTerm=" + searchTerm + "&q=" + q + "&page="
							+ (searchPageResult.getPageNumber() - 1));
		}
		if (searchPageResult.getPageNumber() < searchPageResult.getTotalPages()
				- 1) {
			model.addAttribute("nextPageUrl",
					"/search?searchTerm=" + searchTerm + "&q=" + q + "&page="
							+ (searchPageResult.getPageNumber() + 1));
		}
		model.addAttribute("searchTerm", searchTerm);

		return "/product/searchlist";
	}

}
