package com.spectra.jewel.batch;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spectra.jewel.data.CollectionGroupData;
import com.spectra.jewel.model.collections.CollectionGroup;
import com.spectra.jewel.model.collections.ItemCollection;
import com.spectra.jewel.repository.ItemCollectionRepository;

@Component
public class CollectionGroupDataItemProcessor implements ItemProcessor<CollectionGroupData, CollectionGroup> {

	@Autowired
	ItemCollectionRepository itemCollectionRepository;

	@Override
	public CollectionGroup process(CollectionGroupData collectionGroupData) throws Exception {
		CollectionGroup collectionGroup = new CollectionGroup();
		collectionGroup.setCode(collectionGroupData.getCode());
		collectionGroup.setName(collectionGroupData.getName());
		if (StringUtils.isNotEmpty(collectionGroupData.getCollectionItemsString())) {
			List<ItemCollection> itemCollections = new ArrayList<ItemCollection>();
			for (String collectionCode : collectionGroupData.getCollectionItemsString().split(":")) {
				ItemCollection itemCollection = itemCollectionRepository.findItemCollectionByCode(collectionCode);
				if (null != itemCollection) {
					itemCollections.add(itemCollection);
				}
			}
			collectionGroup.setCollections(itemCollections);
		}
		return collectionGroup;
	}
}