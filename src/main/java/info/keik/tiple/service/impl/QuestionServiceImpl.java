package info.keik.tiple.service.impl;

import info.keik.tiple.model.Question;
import info.keik.tiple.service.QuestionService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Override
	public List<Question> getAll() {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public Question get(Integer id) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public List<Question> getByTag(String tagName) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public Question add(Question question) {
		throw new RuntimeException("Not implemented");
	}

}
