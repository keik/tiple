package info.keik.tiple.repository;

import info.keik.tiple.model.Answer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AnswerRepository {

	public List<Answer> getByQuestionId(Integer qid);

	public Integer add(Answer user);

	public Integer getVote(@Param("id") Integer id, @Param("userId") String userId);

	public void updateVote(@Param("id") Integer id, @Param("userId") String userId, @Param("value") Integer value);

}
