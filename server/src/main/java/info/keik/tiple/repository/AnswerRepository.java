package info.keik.tiple.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import info.keik.tiple.model.Answer;

public interface AnswerRepository {

	public List<Answer> getByQuestionId(@Param("qid") Integer qid);

	public Integer add(Answer user);

	public Integer getVote(@Param("id") Integer id, @Param("userId") String userId);

	public void updateVote(@Param("id") Integer id, @Param("userId") String userId, @Param("value") Integer value);

}
