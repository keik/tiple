package info.keik.tiple.service;

import java.util.List;

import info.keik.tiple.model.Answer;

public interface AnswerService {

	/**
	 * Return answers that specified with referenced question ID.
	 * 
	 * @param question id
	 * @return
	 */
	List<Answer> getByQuestionId(Integer id);

	/**
	 * Add a new answer.
	 * 
	 * @param answer
	 */
	void add(Answer answer);

	/**
	 * Vote up to specified answer.
	 * 
	 * @param answerId
	 * @param userId
	 */
	void voteUp(Integer answerId, String userId);

	/**
	 * Vote down to specified answer.
	 * 
	 * @param answerId
	 * @param userId
	 */
	void voteDown(Integer answerId, String userId);

	/**
	 * Vote down to specified answer.
	 * 
	 * @param answerId
	 * @param userId
	 */
	void unvote(Integer answerId, String userId);
}
