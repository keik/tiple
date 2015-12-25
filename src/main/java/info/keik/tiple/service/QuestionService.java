package info.keik.tiple.service;

import info.keik.tiple.model.Question;
import info.keik.tiple.model.Tag;

import java.util.List;

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
	List<Question> getByTag(Tag tag);

	/**
	 * Add a new question.
	 * 
	 * @param a question
	 * @return created question
	 */
	Question add(Question question);

}
