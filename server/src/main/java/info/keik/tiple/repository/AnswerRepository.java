package info.keik.tiple.repository;

import info.keik.tiple.model.Answer;

import java.util.List;

public interface AnswerRepository {

	public List<Answer> getByQuestionsId(Integer qid);

	public int add(Answer user);

}
