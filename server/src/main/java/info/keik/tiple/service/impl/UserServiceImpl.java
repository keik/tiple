package info.keik.tiple.service.impl;

import info.keik.tiple.model.User;
import info.keik.tiple.repository.UserRepository;
import info.keik.tiple.service.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getAll() {
		return userRepository.getAll();
	}

	@Override
	public User get(String id) {
		return userRepository.get(id);
	}

	@Override
	public void add(User user) throws UserService.UserDuplicateException {
		try {
			userRepository.add(user);
		} catch (DuplicateKeyException e) {
			throw new UserService.UserDuplicateException(e);
		}
	}

}
