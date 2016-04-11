package info.keik.tiple.service.mock;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import info.keik.tiple.model.User;
import info.keik.tiple.service.UserService;

@Service
public class UserServiceMock implements UserService {

	public List<User> users = new ArrayList<>();

	private PasswordEncoder passowordEncoder = new BCryptPasswordEncoder();

	{
		users.add(new User() {
			{
				setId("alice");
				setName("Alice");
				setEmail("alice@example.net");
				setPassword(passowordEncoder.encode("alice"));
			}
		});
		users.add(new User() {
			{
				setId("bob");
				setName("Bob");
				setEmail("bob@example.net");
				setPassword(passowordEncoder.encode("bob"));
			}
		});
		users.add(new User() {
			{
				setId("carol");
				setName("Carol");
				setEmail("carol@example.net");
				setPassword(passowordEncoder.encode("carol"));
			}
		});
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public User get(String id) {
		return users.stream()
				.filter(u -> u.getId().equals(id))
				.findAny().get();
	}

	@Override
	public void add(User user) {
		users.add(user);
	}

}
