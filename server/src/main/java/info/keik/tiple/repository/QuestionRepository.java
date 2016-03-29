package info.keik.tiple.repository;

import info.keik.tiple.model.Question;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface QuestionRepository {

	public Question get(Integer userId);

	public int add(Question question);

	public List<Question> search(@Param("tagName") String tagName, @Param("begin") Integer begin, @Param("count") Integer count);

	public int count(@Param("tagName") String tagName);

}
