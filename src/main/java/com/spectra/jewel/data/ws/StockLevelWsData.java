package com.spectra.jewel.data.ws;

import lombok.Data;

@Data
public class StockLevelWsData {
	private Long id;
	private Integer quantity;
	private String stockLevel;
	private String metalColor;
	private String metalPurity;
	private String size;
	private String diamondGrade;

}
