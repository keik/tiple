package info.keik.tiple.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import info.keik.tiple.model.Question;

public interface QuestionRepository {

	public Question get(Integer userId);

	public Integer add(Question question);

	public List<Question> search(@Param("tagName") String tagName, @Param("begin") Integer begin, @Param("count") Integer count);

	public Integer count(@Param("tagName") String tagName);

	public Integer addViewsCount(@Param("id") Integer id);

	public Integer getVote(@Param("id") Integer id, @Param("userId") String userId);

	public void updateVote(@Param("id") Integer id, @Param("userId") String userId, @Param("value") Integer value);

}
