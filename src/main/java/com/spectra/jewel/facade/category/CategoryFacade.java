package com.spectra.jewel.facade.category;

import java.util.Collection;

import com.spectra.jewel.data.CategoryData;
import com.spectra.jewel.data.ws.CategoryWsData;
import com.spectra.jewel.model.product.Product;

public interface CategoryFacade {
	CategoryData getCategoryForCode(String categoryCode);
	Collection<CategoryData> getAllCategories();
	Collection<CategoryWsData> getAllWsCategories();
	Collection<CategoryWsData> getCategoriesWsData(Product product);

}
