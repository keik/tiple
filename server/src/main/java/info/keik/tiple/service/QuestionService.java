package info.keik.tiple.service;

import info.keik.tiple.model.Question;
import info.keik.tiple.model.Tag;

import java.util.List;

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
	 * @param tag name
	 * @return count of all questions count
	 */
	Integer getTotalCount(String tagName);

	/**
	 * Search questions with pagination.
	 * 
	 * @param tag name
	 * @param page number
	 * @param item count per page
	 * @return questions that specified with conditions
	 */
	List<Question> search(String tagName, Integer page, Integer pageSize);

	/**
	 * Add views counter of the specified question.
	 * 
	 * @param question id
	 * @return views count of the specified question
	 */
	void addViewsCount(Integer id);

	/**
	 * Vote to specified question.
	 * 
	 * @param questionId
	 * @param userId
	 */
	void vote(Integer questionId, Integer userId);

	/**
	 * Vote down to specified question.
	 * 
	 * @param questionId
	 * @param userId
	 */
	void voteDown(Integer questionId, Integer userId);

}
