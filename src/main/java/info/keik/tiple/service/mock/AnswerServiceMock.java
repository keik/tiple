package info.keik.tiple.service.mock;

import info.keik.tiple.controller.QuestionController;
import info.keik.tiple.model.Answer;
import info.keik.tiple.service.AnswerService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceMock implements AnswerService {

	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

	public List<Answer> answers = new ArrayList<>();

	{
		answers.add(new Answer() {
			{
				setRefQuestionId(0);
				setContent("this is a answer 1");
			}
		});
		answers.add(new Answer() {
			{
				setRefQuestionId(0);
				setContent("this is a answer 2");
			}
		});
		answers.add(new Answer() {
			{
				setRefQuestionId(1);
				setContent("this is a answer 3");
			}
		});
	}

	@Override
	public List<Answer> getByQuestionsId(Integer id) {
		return answers.stream()
				.filter(a -> id == a.getRefQuestionId())
				.collect(Collectors.toList());
	}

	@Override
	public void add(Answer answer) {
		answers.add(answer);
	}

}
