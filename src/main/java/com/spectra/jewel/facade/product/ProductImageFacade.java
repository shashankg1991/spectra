package com.spectra.jewel.facade.product;

import java.util.Collection;

import com.spectra.jewel.data.ws.ImageWsData;
import com.spectra.jewel.model.product.Product;

public interface ProductImageFacade {

	Collection<ImageWsData> getImagesWsData(Product product);

}
