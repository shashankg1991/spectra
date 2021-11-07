package com.spectra.jewel.facade.generic;

import com.spectra.jewel.data.ws.PriceWsData;
import com.spectra.jewel.model.Price;

public interface PriceFacade {

	PriceWsData getPriceWsData(final Price price);

}
