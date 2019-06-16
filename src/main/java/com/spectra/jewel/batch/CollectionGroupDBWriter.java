package com.spectra.jewel.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spectra.jewel.model.collections.CollectionGroup;
import com.spectra.jewel.repository.CollectionGroupRepository;

@Component
public class CollectionGroupDBWriter implements ItemWriter<CollectionGroup> {

	@Autowired
	private CollectionGroupRepository collectionGroupRepository;

	@Override
	public void write(List<? extends CollectionGroup> collectionGroups) throws Exception {
		collectionGroupRepository.saveAll(collectionGroups);
	}
}