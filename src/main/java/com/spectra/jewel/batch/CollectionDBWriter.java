package com.spectra.jewel.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spectra.jewel.model.collections.ItemCollection;
import com.spectra.jewel.repository.ItemCollectionRepository;

@Component
public class CollectionDBWriter implements ItemWriter<ItemCollection> {

	@Autowired
	private ItemCollectionRepository itemCollectionRepository;

	@Override
	public void write(List<? extends ItemCollection> itemCollections) throws Exception {
		itemCollectionRepository.saveAll(itemCollections);
	}
}