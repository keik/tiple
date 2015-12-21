package info.keik.tiple.service.impl;

import info.keik.tiple.model.Answer;
import info.keik.tiple.service.AnswerService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Override
	public List<Answer> getByQuestionsId(Integer id) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void add(Answer answer) {
		throw new RuntimeException("Not implemented");
	}

}
