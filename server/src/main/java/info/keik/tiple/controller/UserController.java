package info.keik.tiple.controller;

import info.keik.tiple.model.User;
import info.keik.tiple.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	UserService userService;

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

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> create(User user) {
		userService.add(user);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

}
