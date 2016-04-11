package info.keik.tiple.service;

import java.util.List;

import info.keik.tiple.model.Answer;
import info.keik.tiple.service.QuestionService.AlreadyVotedException;

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
	 * Vote to specified answer.
	 *
	 * @param answerId answer ID
	 * @param userId user ID
	 * @param value voting value
	 */
	void vote(Integer answerId, String userId, Integer value) throws AlreadyVotedException;

	/**
	 * Vote down to specified answer.
	 *
	 * @param answerId
	 * @param userId
	 */
	void unvote(Integer answerId, String userId);

	/**
	 * Return value of vote by specific user.
	 *
	 * @param answerId list of answers ID
	 * @param userId user ID
	 * @return vote value for specified answer
	 */
	Integer getVote(Integer answerId, String userId);

}
