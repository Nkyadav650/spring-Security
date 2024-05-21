package com.Employee.Controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@GetMapping("/currentUser")
	public String getLoggedUser(Principal principal) {
		return principal.getName();
	}
}
