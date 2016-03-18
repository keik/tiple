package info.keik.tiple.repository;

import info.keik.tiple.model.Question;
import info.keik.tiple.model.Tag;

import java.util.List;

public interface QuestionRepository {

	public List<Question> getAll();

	public Question get(Integer userId);

	public List<Question> getByTag(Tag tag);

	public int add(Question question);

}
