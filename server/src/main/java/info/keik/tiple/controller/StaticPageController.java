package info.keik.tiple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticPageController {

	@RequestMapping("/signup")
	public String signup(UserController.UserForm userForm) {
		return "static-pages/signup.html";
	}

	@RequestMapping("/login")
	public String login() {
		return "static-pages/login.html";
	}

	@RequestMapping("/about")
	public String about() {
		return "static-pages/about.html";
	}

}
