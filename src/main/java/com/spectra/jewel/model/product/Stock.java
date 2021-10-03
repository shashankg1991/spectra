package com.spectra.jewel.model.product;

import java.util.Map;

/*
 * -It will have value each metal and stone entry for which the stock is defined
 */
public class Stock {
	Map<String, MetalType> metalEntryCodeMetalTypeMap;
	Map<String, StoneType> stoneEntryCodeStoneTypeMap;
	int quantity;
}
