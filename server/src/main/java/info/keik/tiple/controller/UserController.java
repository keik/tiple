package info.keik.tiple.controller;

import info.keik.tiple.model.User;
import info.keik.tiple.service.UserService;
import info.keik.tiple.service.UserService.UserDuplicateException;

import java.util.List;

import javax.validation.Valid;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> index() {
		return userService.getAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(Model model, @PathVariable("id") String id) {
		User user = userService.get(id);
		model.addAttribute("user", user);
		return "users/show.html";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(@Valid UserController.UserForm userForm, BindingResult bindingResult) throws UserService.UserDuplicateException {
		if (bindingResult.hasErrors()) {
			System.out.println("@@@@" + bindingResult.getObjectName());
			return "static-pages/signup.html";
		}
		User user = userForm;
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		try {
			userService.add(user);
		} catch (UserDuplicateException e) {
			// TODO detect which key is duplicated (it seem not to be able to
			// retrieve from exception...)
			bindingResult.addError(new FieldError(bindingResult.getObjectName(), "id", "Already taken (TODO message properties)"));
			bindingResult.addError(new FieldError(bindingResult.getObjectName(), "email", "Already taken (TODO message properties)"));
			return "static-pages/signup.html";
		}

		return "redirect:/";
	}

	@Data
	@EqualsAndHashCode(callSuper = false)
	static class UserForm extends User {

		public UserForm() {
		}

		@NotBlank
		private String id;

		@NotBlank
		@Email
		private String email;

		@NotBlank
		private String password;

	}
}
