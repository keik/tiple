package info.keik.tiple.repository;

import info.keik.tiple.model.User;

import java.util.List;

public interface UserRepository {

	public List<User> getAll();

	public User get(String userId);

	public int add(User user);

}
