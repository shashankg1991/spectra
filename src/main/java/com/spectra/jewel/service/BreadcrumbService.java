package com.spectra.jewel.service;

import java.util.List;

import com.spectra.jewel.data.Breadcrumb;

public interface BreadcrumbService {

	List<Breadcrumb> getBreadcrumbs(String productCode);

}
