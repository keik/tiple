package info.keik.tiple.repository;

import info.keik.tiple.model.User;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserRepository {

	@Select("SELECT * FROM user")
	public List<User> getAll();

	@Select("SELECT * FROM user WHERE id = #{id}")
	public User getById(String userId);

	@Insert("insert into user (email, name, password) values(#{email}, #{name}, #{password})")
	public int addUser(User user);

}
