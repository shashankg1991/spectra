package com.spectra.jewel.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.spectra.jewel.data.ItemCollectionData;
import com.spectra.jewel.model.collections.ItemCollection;

@Component
public class CollectionDataItemProcessor implements ItemProcessor<ItemCollectionData, ItemCollection> {

	@Override
	public ItemCollection process (ItemCollectionData itemCollectionData) throws Exception {
		ItemCollection itemCollection = new ItemCollection();
		itemCollection.setCode(itemCollectionData.getCode());
		itemCollection.setName(itemCollectionData.getName());
		return itemCollection;
	}
}