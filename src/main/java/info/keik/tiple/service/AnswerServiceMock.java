package info.keik.tiple.service;

import info.keik.tiple.model.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class AnswerServiceMock implements AnswerService {

	public List<Answer> answers = new ArrayList<>();

	{
		answers.add(new Answer() {{ refQuestionId = 0; content = "this is a answer 1"; }});
		answers.add(new Answer() {{ refQuestionId = 0; content = "this is a answer 2"; }});
		answers.add(new Answer() {{ refQuestionId = 1; content = "this is a answer 3"; }});
	}

	@Override
	public List<Answer> getByQuestionsId(Integer id) {
		return answers.stream()
				.filter(a -> id == a.refQuestionId)
				.collect(Collectors.toList());
	}

}
