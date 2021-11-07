package com.spectra.jewel.repository.specification;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.spectra.jewel.model.product.Product;

@SuppressWarnings("serial")
public class ProductSpecification implements Specification<Product> {

	private final ProductSearchCriteria criteria;

	public ProductSpecification(ProductSearchCriteria criteria) {
		this.criteria = criteria;
	}

	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (Objects.nonNull(criteria.getId())) {
			predicates.add(
					criteriaBuilder.equal(root.get("id"), criteria.getId()));
		}
		if (StringUtils.isNotEmpty(criteria.getCode())) {
			predicates.add(criteriaBuilder.like(root.get("code"),
					"%" + criteria.getCode() + "%"));
		}
		if (StringUtils.isNotEmpty(criteria.getText())) {
			predicates.add(criteriaBuilder.like(root.get("name"),
					"%" + criteria.getCode() + "%"));
			predicates.add(criteriaBuilder.like(root.get("description"),
					"%" + criteria.getCode() + "%"));
		}

		if (CollectionUtils.isNotEmpty(predicates)) {
			return criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()]));
		}
		return null;
	}

}
