package info.keik.tiple.repository;

import java.util.List;

import info.keik.tiple.model.User;

public interface UserRepository {

	public List<User> getAll();

	public User get(String userId);

	public int add(User user);

}
