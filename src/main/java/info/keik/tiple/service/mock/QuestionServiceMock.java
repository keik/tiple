package info.keik.tiple.service.mock;

import info.keik.tiple.model.Question;
import info.keik.tiple.model.Tag;
import info.keik.tiple.model.User;
import info.keik.tiple.service.QuestionService;
import info.keik.tiple.service.TagService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceMock implements QuestionService {

	@Autowired
	TagService tagService;

	public List<Question> questions = new ArrayList<>();

	{
		questions.add(new Question("Lorem ipsum", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.") {
			{
				setId(0);
				Tag[] ts = { new Tag("javascript"), new Tag("jquery") };
				setTags(Arrays.asList(ts));
				setCreatedBy(new User() {
					{
						setId("alice");
						setName("Alice");
					}
				});
				setCreatedAt(new Date());
				setAnswersCount(2);
			}
		});
		questions.add(new Question("Et case malorum", "Et case malorum omittantur has, eos eu nibh minim vitae, nobis oblique pri id. Et mea veri possit molestiae, nec ea vidisse tritani prodesset, est dictas torquatos necessitatibus no. Quo ne pericula salutatus, nec eu putent convenire instructior. Cum te diam postulant, qui iisque prompta ex. Numquam abhorreant his cu, vis ut vide delicatissimi. No vis vidit facete impedit. Reque maiestatis eum ea, ut consul graeco sit.") {
			{
				setId(1);
				Tag[] ts = { new Tag("java"), new Tag("maven") };
				setTags(Arrays.asList(ts));
				setCreatedBy(new User() {
					{
						setId("alice");
						setName("Alice");
					}
				});
				setCreatedAt(new Date());
				setAnswersCount(1);
			}
		});
		questions.add(new Question("Et case malorum omittantur", "Et case malorum omittantur has, eos eu nibh minim vitae, nobis oblique pri id. Et mea veri possit molestiae, nec ea vidisse tritani prodesset, est dictas torquatos necessitatibus no. Quo ne pericula salutatus, nec eu putent convenire instructior. Cum te diam postulant, qui iisque prompta ex. Numquam abhorreant his cu, vis ut vide delicatissimi. No vis vidit facete impedit. Reque maiestatis eum ea, ut consul graeco sit.") {
			{
				setId(2);
				Tag[] ts = { new Tag("javascript"), new Tag("node") };
				setTags(Arrays.asList(ts));
				setCreatedBy(new User() {
					{
						setId("alice");
						setName("Alice");
					}
				});
				setCreatedAt(new Date());
				setAnswersCount(0);
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

	@Override
	public Question add(Question question) {
		question.setId(questions.size());
		question.setCreatedAt(new Date());
		questions.add(question);

		List<Tag> tags = tagService.getAll();
		question.getTags().stream()
				.filter(t -> !tags.contains(t))
				.forEach(t -> tags.add(t));

		return question;
	}

}
