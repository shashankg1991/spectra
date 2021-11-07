package com.spectra.jewel.facade.generic;

import com.spectra.jewel.data.ws.WeightWsData;
import com.spectra.jewel.model.Weight;

public interface WeightFacade {

	WeightWsData getWeightWsData(final Weight weight);

}
