package info.keik.tiple.repository;

import info.keik.tiple.model.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserRepository {

	@Select("SELECT * FROM user WHERE id = #{userId}")
	public User getUser(long userId);

	@Insert("insert into user (email, userName) values(#{email}, #{userName})")
	public int addUser(User user);

}
