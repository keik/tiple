package info.keik.tiple.service.impl;

import info.keik.tiple.controller.QuestionController;
import info.keik.tiple.model.Answer;
import info.keik.tiple.service.AnswerService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

	@Override
	public List<Answer> getByQuestionsId(Integer id) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void add(Answer answer) {
		throw new RuntimeException("Not implemented");
	}

}
