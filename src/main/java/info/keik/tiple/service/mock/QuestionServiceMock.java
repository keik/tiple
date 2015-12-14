package info.keik.tiple.service.mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import info.keik.tiple.model.Question;
import info.keik.tiple.model.Tag;
import info.keik.tiple.service.QuestionService;

@Service
public class QuestionServiceMock implements QuestionService {

	public List<Question> questions = new ArrayList<>();

	{
		questions.add(new Question("q1", "this is q1") {
			{
				setId(0);
				Tag[] ts = { new Tag("javascript"), new Tag("jquery") };
				setTags(Arrays.asList(ts));
			}
		});
		questions.add(new Question("q2", "this is q2") {
			{
				setId(1);
				Tag[] ts = { new Tag("java"), new Tag("maven") };
				setTags(Arrays.asList(ts));
			}
		});
		questions.add(new Question("q3", "this is q3") {
			{
				setId(2);
				Tag[] ts = { new Tag("javascript"), new Tag("node") };
				setTags(Arrays.asList(ts));
			}
		});
	}

	@Override
	public List<Question> getAll() {
		return questions;
	}

	@Override
	public Question get(Integer id) {
		return questions.stream()
				.filter(q -> id == q.getId())
				.findAny().get();
	}

	@Override
	public List<Question> getByTag(String tagName) {
		return questions.stream()
				.filter(q -> q.getTags().stream()
						.anyMatch(t -> t.getName().equals(tagName)))
				.collect(Collectors.toList());
	}

}
