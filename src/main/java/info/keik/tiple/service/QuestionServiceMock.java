package info.keik.tiple.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import info.keik.tiple.model.Question;

@Service
public class QuestionServiceMock implements QuestionService {

	public List<Question> questions = new ArrayList<>();

	{
		questions.add(new Question("q1", "this is q1"));
		questions.add(new Question("q2", "this is q2"));
		questions.add(new Question("q3", "this is q3"));
	}

	@Override
	public List<Question> getAll() {
		return questions;
	}

}
