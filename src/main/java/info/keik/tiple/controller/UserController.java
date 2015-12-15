package info.keik.tiple.controller;

import info.keik.tiple.model.User;
import info.keik.tiple.repository.UserRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/users")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(TagController.class);
	
	@Autowired
	UserRepository userRepository;

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<User> index() {
		return userRepository.getAll();
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User show(@PathVariable("id") Integer id) {
		return userRepository.getById(id);
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> create(User user) {
		userRepository.addUser(user);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

}
