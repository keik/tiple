package info.keik.tiple.service;

import java.util.List;

import info.keik.tiple.model.Question;

public interface QuestionService {

	/**
	 * Return a question that specified with ID.
	 *
	 * @param id
	 * @return a question that specified with ID
	 */
	Question get(Integer id);

	/**
	 * Add a new question.
	 *
	 * @param a question
	 * @return created question
	 */
	Question add(Question question);

	/**
	 * Return count of all questions.
	 *
	 * @param tagName tag name
	 * @return count of all questions count
	 */
	Integer getTotalCount(String tagName);

	/**
	 * Search questions with pagination.
	 *
	 * @param tagName tag name
	 * @param page page number
	 * @param pageSize items count per page
	 * @return questions that specified with conditions
	 */
	List<Question> search(String tagName, Integer page, Integer pageSize);

	/**
	 * Add views counter of the specified question.
	 *
	 * @param id question ID
	 * @return views count of the specified question
	 */
	void addViewsCount(Integer id);

	/**
	 * Vote to specified question.
	 *
	 * @param questionId question ID
	 * @param userId user ID
	 * @param value voting value
	 */
	void vote(Integer questionId, String userId, Integer value) throws AlreadyVotedException;

	/**
	 * Vote down to specified question.
	 *
	 * @param questionId question ID
	 * @param userId user ID
	 */
	void unvote(Integer questionId, String userId);

	/**
	 * Return value of vote by specific user.
	 *
	 * @param questionId question ID
	 * @param userId user ID
	 * @return vote value for specified question
	 */
	Integer getVote(Integer questionId, String userId);

	/**
	 * Exception when voting to already voted question.
	 */
	static class AlreadyVotedException extends Exception {
		private static final long serialVersionUID = 4960199252512062428L;

		public AlreadyVotedException() {
			super();
		}

		public AlreadyVotedException(Exception e) {
			super(e);
		}
	}
}
