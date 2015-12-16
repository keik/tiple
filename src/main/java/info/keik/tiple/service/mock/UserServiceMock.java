package info.keik.tiple.service.mock;

import info.keik.tiple.model.User;
import info.keik.tiple.service.UserService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceMock implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceMock.class);

	public List<User> users = new ArrayList<>();

	{
		users.add(new User() {
			{
				setId("alice");
				setName("Alice");
				setEmail("user1@example.net");
				setPassword("password");
			}
		});
		users.add(new User() {
			{
				setId("bob");
				setName("Bob");
				setEmail("user2@example.net");
				setPassword("password");
			}
		});
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public User getById(String id) {
		return users.stream()
				.filter(u -> u.getId().equals(id))
				.findAny().get();
	}

	@Override
	public void add(User user) {
		users.add(user);
	}

}
