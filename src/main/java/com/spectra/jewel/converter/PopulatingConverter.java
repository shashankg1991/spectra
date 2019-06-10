package com.spectra.jewel.converter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.core.convert.converter.Converter;

public abstract class PopulatingConverter<S, T> implements Converter<S, T> {
	abstract public void populate(S source, T target);

	public List<T> convertAll(List<S> sources) {
		if (CollectionUtils.isNotEmpty(sources)) {
			return sources.stream().map(source -> convert(source)).collect(Collectors.toList());
		} else {
			return Collections.emptyList();
		}
	}

}
