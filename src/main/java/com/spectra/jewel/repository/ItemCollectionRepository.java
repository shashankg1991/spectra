package com.spectra.jewel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spectra.jewel.model.collections.ItemCollection;

@Repository
public interface ItemCollectionRepository extends JpaRepository<ItemCollection, Long> {

	ItemCollection findItemCollectionByCode(String code);

}
