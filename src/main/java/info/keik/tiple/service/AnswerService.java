package info.keik.tiple.service;

import info.keik.tiple.model.Answer;

import java.util.List;

public interface AnswerService {

	List<Answer> getByQuestionsId(Integer id);

}
