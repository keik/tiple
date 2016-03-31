package info.keik.tiple.service;

import info.keik.tiple.model.User;

import java.util.List;

public interface UserService {

	/**
	 * Return all users
	 * 
	 * @return all users
	 */
	List<User> getAll();

	/**
	 * Return a user that specified with user ID.
	 * 
	 * @param user ID
	 * @return a user that specified with user ID
	 */
	User get(String id);

	/**
	 * Add a user.
	 * 
	 * @param user
	 */
	void add(User user) throws UserService.UserDuplicateException;

	class UserDuplicateException extends Exception {
		private static final long serialVersionUID = -7539174489527480388L;
		public UserDuplicateException(Exception e) {
			super(e);
		}
	}

}
