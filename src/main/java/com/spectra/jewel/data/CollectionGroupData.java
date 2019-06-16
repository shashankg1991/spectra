package com.spectra.jewel.data;

import java.util.List;

public class CollectionGroupData {
	private String code;
	private String name;
	private List<String> collectionItems;
	private String collectionItemsString;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCollectionItems() {
		return collectionItems;
	}

	public void setCollectionItems(List<String> collectionItems) {
		this.collectionItems = collectionItems;
	}

	public String getCollectionItemsString() {
		return collectionItemsString;
	}

	public void setCollectionItemsString(String collectionItemsString) {
		this.collectionItemsString = collectionItemsString;
	}
	

}
