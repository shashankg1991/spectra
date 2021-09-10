package com.spectra.jewel.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import com.spectra.jewel.data.Breadcrumb;
import com.spectra.jewel.model.product.Category;
import com.spectra.jewel.model.product.Product;
import com.spectra.jewel.service.BreadcrumbService;
import com.spectra.jewel.service.ProductService;

@Service("breadcrumbService")
public class DefaultBreadcrumbService implements BreadcrumbService {

	@Resource
	ProductService productService;

	@Override
	public List<Breadcrumb> getBreadcrumbs(String productCode) {
		Product product = productService.getProductForCode(productCode);
		if (Objects.nonNull(product)) {
			Collection<Category> categories = product.getCategories();
			if (CollectionUtils.isNotEmpty(categories)) {
				List<Breadcrumb> breadcrumbs = new ArrayList<Breadcrumb>();
				addCategoryBreadCrumb(breadcrumbs,
						categories.iterator().next());
				addHomeBreadCrumb(breadcrumbs);
				Collections.reverse(breadcrumbs);
				return breadcrumbs;
			}
		}
		return Collections.emptyList();
	}

	private void addHomeBreadCrumb(List<Breadcrumb> breadcrumbs) {
		Breadcrumb breadcrumb = new Breadcrumb();
		breadcrumb.setName("Home");
		breadcrumb.setUrl("/");
		breadcrumbs.add(breadcrumb);
	}

	private void addCategoryBreadCrumb(List<Breadcrumb> breadcrumbs,
			Category category) {
		if (category == null) {
			return;
		}
		Breadcrumb breadcrumb = new Breadcrumb();
		breadcrumb.setName(category.getName());
		breadcrumb.setUrl("/c/" + category.getCode());
		breadcrumbs.add(breadcrumb);

		if (CollectionUtils.isNotEmpty(category.getSuperCategories())) {
			addCategoryBreadCrumb(breadcrumbs,
					category.getSuperCategories().iterator().next());
		}
	}

}
