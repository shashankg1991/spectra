package com.spectra.jewel.controller.admin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHomePageController {

	@GetMapping
	public String adminHome(HttpServletRequest request, Model model) {
		return "pages/admin/homepage";
	}

}
