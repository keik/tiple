package info.keik.tiple.service.impl;

import info.keik.tiple.model.User;
import info.keik.tiple.service.UserService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public List<User> getAll() {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public User getById(String id) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void add(User user) {
		throw new RuntimeException("Not implemented");
	}

}
