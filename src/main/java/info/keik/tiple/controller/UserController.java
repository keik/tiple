package info.keik.tiple.controller;

import info.keik.tiple.model.User;
import info.keik.tiple.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public User index(@PathVariable("id") Integer id) {
		return userRepository.getUser(id);
	}

	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> create() {
		userRepository.addUser(new User() {
			{
				setName("unko");
			}
		});
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

}
