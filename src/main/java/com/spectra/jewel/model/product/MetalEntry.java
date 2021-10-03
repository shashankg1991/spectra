package com.spectra.jewel.model.product;

import java.util.List;

/*-
 * Product can have multiple metal groups.
 * Each group represents a type of metal that the product will be having.
 * A product can for example have both gold and platinum, in this case there will be 2 metal groups.
 * Each group has a list of metal options available for the product like 18k yellow, 14k rose, etc.
 * The stock will have reference to metal option to indicate if the item is in stock or not. 
 *  
 * @author Shashank.Gupta
 *
 */
public class MetalEntry {
	String code;
	String description;
	List<MetalType> metalOptions;
	double weight;
}
