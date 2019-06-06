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

import com.spectra.jewel.model.Role;
import com.spectra.jewel.model.User;
import com.spectra.jewel.service.UserService;
import com.spectra.jewel.service.impl.RoleService;

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
			errorMessge = "Username or Password is incorrect !!";
		}
		if (logout != null) {
			errorMessge = "You have been successfully logged out !!";
		}
		model.addAttribute("errorMessge", errorMessge);
		return "user/login";
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
		User user = new User();
		model.addAttribute("user", user);
		return "user/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String saveRegistration(@Valid User user, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			System.out.println("There are errors");
			return "user/register";
		}
		userService.save(user);

		System.out.println("First Name : " + user.getFirstName());
		System.out.println("Last Name : " + user.getLastName());
		System.out.println("SSO ID : " + user.getUsername());
		System.out.println("Password : " + user.getPassword());
		System.out.println("Email : " + user.getEmail());
		System.out.println("Checking UsrProfiles....");
		if (user.getRoles() != null) {
			for (Role role : user.getRoles()) {
				System.out.println("Profile : " + role.getName());
			}
		}

		model.addAttribute("success", "User " + user.getFirstName() + " has been registered successfully");
		return "homepage";
	}
	
	 @ModelAttribute("roles")
	    public Iterable<Role> initializeProfiles() {
	        return roleService.findAll();
	    }

}
