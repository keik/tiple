package info.keik.tiple.service.impl;

import info.keik.tiple.model.User;
import info.keik.tiple.repository.UserRepository;
import info.keik.tiple.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAll() {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public User getById(String id) {
		return userRepository.getById(id);
	}

	@Override
	public void add(User user) {
		throw new RuntimeException("Not implemented");
	}

}
