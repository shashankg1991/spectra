package com.spectra.jewel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spectra.jewel.model.collections.CollectionGroup;

@Repository
public interface CollectionGroupRepository extends JpaRepository<CollectionGroup, Long> {

	CollectionGroup findByCode(String code);

}
