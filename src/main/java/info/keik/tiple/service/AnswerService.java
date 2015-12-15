package info.keik.tiple.service;

import info.keik.tiple.model.Answer;

import java.util.List;

public interface AnswerService {

	/**
	 * Return answers that specified with referenced question ID.
	 * 
	 * @param question id
	 * @return
	 */
	List<Answer> getByQuestionsId(Integer id);

	/**
	 * Add a new answer.
	 * 
	 * @param answer
	 */
	void add(Answer answer);

}
