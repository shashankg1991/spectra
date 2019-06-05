package com.spectra.jewel.config.security;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(1)
public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {
	// Creates a filter at position 1 for spring security.
	// No annotation is needed.
	// Just a presence of class.
}
