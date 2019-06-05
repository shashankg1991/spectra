package com.spectra.jewel.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {
	@GetMapping
    public String home(HttpServletRequest request, Model model) {
		SecurityContextHolder.getContext().getAuthentication().getName();
		request.isUserInRole("USER");
		request.getRemoteUser();
        return "homepage";
    }
}
