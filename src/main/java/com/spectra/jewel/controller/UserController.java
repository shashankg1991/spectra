package com.spectra.jewel.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spectra.jewel.exception.DuplicateException;
import com.spectra.jewel.forms.UserRegistrationForm;
import com.spectra.jewel.model.user.Role;
import com.spectra.jewel.model.user.User;
import com.spectra.jewel.service.RoleService;
import com.spectra.jewel.service.UserService;

@Controller
public class UserController {

	@Resource
	UserService userService;

	@Resource
	RoleService roleService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, Model model) {
		String errorMessge = null;
		if (error != null) {
			errorMessge = "Username or Password is invalid !!";
		}
		if (logout != null) {
			errorMessge = "You have been successfully logged out !!";
		}
		model.addAttribute("errorMessge", errorMessge);
		return "pages/user/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout=true";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		UserRegistrationForm userRegistrationForm = new UserRegistrationForm();
		model.addAttribute("userRegistrationForm", userRegistrationForm);
		return "pages/user/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveRegistration(@ModelAttribute @Valid UserRegistrationForm userRegistrationForm,
			BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			System.out.println("There are errors");
			return "pages/user/register";
		}

		// TODO: Create converter and populator
		User user = new User();
		user.setEmail(userRegistrationForm.getEmail());
		user.setFirstName(userRegistrationForm.getFirstName());
		user.setLastName(userRegistrationForm.getLastName());
		user.setPassword(userRegistrationForm.getPassword());
		try {
			userService.register(user);
		} catch (DuplicateException de) {
			model.addAttribute("errorMessge", de.getMessage());
			return "pages/user/register";
		}
		return "pages/homepage";
	}

	@ModelAttribute("roles")
	public Iterable<Role> initializeProfiles() {
		return roleService.findAll();
	}

}
