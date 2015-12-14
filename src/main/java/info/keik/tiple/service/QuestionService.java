package info.keik.tiple.service;

import java.util.List;

import info.keik.tiple.model.Question;

public interface QuestionService {

	/**
	 * Return all questions.
	 * 
	 * @return all questions
	 */
	List<Question> getAll();

	/**
	 * Return a question that specified with ID.
	 * 
	 * @param id
	 * @return a question that specified with ID
	 */
	Question get(Integer id);

	/**
	 * Return questions that specified with tag name.
	 * 
	 * @param tag name
	 * @return questions that specified width tag name
	 */
	List<Question> getByTag(String tagName);

}
