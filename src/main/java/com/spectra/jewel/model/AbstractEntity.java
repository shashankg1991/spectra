package com.spectra.jewel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.domain.Persistable;

import lombok.Data;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class AbstractEntity implements Persistable<Long> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@CreationTimestamp
	@Column(updatable = false)
	protected Date createdTime;

	@UpdateTimestamp
	protected Date modifiedTime;

	@CreatedBy
	@Column(updatable = false)
	protected String createdBy;

	@LastModifiedBy
	protected String lastModifiedBy;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public boolean isNew() {
		return getId() == null;
	}

	public void setId(final Long id) {
		this.id = id;
	}

}