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
		for (int i = 0; i < 50; i++) {
			addDummyQuestion(i % 5);
		}
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
	public List<Question> getByTag(Tag tag) {
		return questions.stream()
				.filter(q -> q.getTags().stream()
						.anyMatch(t -> t.getName().equals(tag.getName())))
				.collect(Collectors.toList());
	}

	@Override
	public Question add(Question question) {
		question.setId(questions.size());
		question.setCreatedAt(new Date());
		question.setAnswersCount(0);
		questions.add(question);

		List<Tag> tags = tagService.getAll();
		question.getTags().stream()
				.filter(t -> !tags.contains(t))
				.forEach(t -> tags.add(t));

		return question;
	}

	@Override
	public Integer getTotalCount() {
		return questions.size();
	}

	@Override
	public List<Question> search(String tagName, Integer page, Integer pageSize) {
		return questions.stream()
				.filter(tagName == null ?
						q -> true :
						q -> q.getTags().stream().anyMatch(t -> t.getName().equals(tagName))
				)
				.collect(Collectors.toList())
				.subList((page - 1) * pageSize, page * pageSize);
	}

	private void addDummyQuestion(int p) {
		Question q = null;
		switch (p) {
		case 0:
			q = new Question("Lorem ipsum", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.") {
				{
					setId(questions.size() + 1);
					Tag[] ts = { new Tag("javascript"), new Tag("jquery") };
					setTags(Arrays.asList(ts));
					setVotes(p * 3);
					setViews(p * 5);
					setCreatedBy(new User() {
						{
							setId("alice");
							setName("Alice");
						}
					});
					setCreatedAt(new Date());
					setAnswersCount(2);
				}
			};
			break;
		case 1:
			q = new Question("Et case malorum", "Et case malorum omittantur has, eos eu nibh minim vitae, nobis oblique pri id. Et mea veri possit molestiae, nec ea vidisse tritani prodesset, est dictas torquatos necessitatibus no. Quo ne pericula salutatus, nec eu putent convenire instructior. Cum te diam postulant, qui iisque prompta ex. Numquam abhorreant his cu, vis ut vide delicatissimi. No vis vidit facete impedit. Reque maiestatis eum ea, ut consul graeco sit.") {
				{
					setId(questions.size() + 1);
					Tag[] ts = { new Tag("java"), new Tag("maven") };
					setTags(Arrays.asList(ts));
					setVotes(p * 3);
					setViews(p * 5);
					setCreatedBy(new User() {
						{
							setId("bob");
							setName("Bob");
						}
					});
					setCreatedAt(new Date());
					setAnswersCount(1);
				}
			};
			break;
		case 2:
			q = new Question("Et case malorum omittantur", "Et case malorum omittantur has, eos eu nibh minim vitae, nobis oblique pri id. Et mea veri possit molestiae, nec ea vidisse tritani prodesset, est dictas torquatos necessitatibus no. Quo ne pericula salutatus, nec eu putent convenire instructior. Cum te diam postulant, qui iisque prompta ex. Numquam abhorreant his cu, vis ut vide delicatissimi. No vis vidit facete impedit. Reque maiestatis eum ea, ut consul graeco sit.") {
				{
					setId(questions.size() + 1);
					Tag[] ts = { new Tag("javascript"), new Tag("node") };
					setTags(Arrays.asList(ts));
					setVotes(p * 3);
					setViews(p * 5);
					setCreatedBy(new User() {
						{
							setId("carol");
							setName("Carol");
						}
					});
					setCreatedAt(new Date());
					setAnswersCount(0);
				}
			};
			break;
		case 3:
			q = new Question("Nulla congue risus vel diam ornare", "Nulla congue risus vel diam ornare, in aliquam nulla lacinia. Duis fermentum faucibus lectus a accumsan. In hac habitasse platea dictumst. Ut a pharetra tellus. Sed maximus purus a semper ornare. Ut dapibus sapien in sollicitudin lacinia. In sit amet diam ac sem dapibus venenatis condimentum eget diam. Ut fermentum velit orci, non vulputate lectus scelerisque non.") {
				{
					setId(questions.size() + 1);
					Tag[] ts = { new Tag("stream"), new Tag("node") };
					setTags(Arrays.asList(ts));
					setVotes(p * 3);
					setViews(p * 5);
					setCreatedBy(new User() {
						{
							setId("dave");
							setName("Dave");
						}
					});
					setCreatedAt(new Date());
					setAnswersCount(0);
				}
			};
			break;
		case 4:
			q = new Question("Cras sit amet iaculis lacus", "Cras sit amet iaculis lacus, consectetur pulvinar risus. Curabitur a erat at mauris convallis varius. Cras sodales egestas pharetra. Aenean sit amet mauris eget lacus imperdiet pellentesque. In hac habitasse platea dictumst. Nulla et scelerisque diam. Etiam fermentum nulla nulla, sit amet semper urna facilisis quis. Phasellus orci sem, auctor at porta ac, semper vel urna. Maecenas et dictum orci, at imperdiet lacus. Fusce mauris lorem, semper faucibus tempor eget, rhoncus eu lorem. In quis tincidunt nunc, id mollis sem. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. In orci tellus, commodo sed vehicula sed, consectetur vitae elit. Nulla vehicula augue eu purus molestie ultrices.") {
				{
					setId(questions.size() + 1);
					Tag[] ts = { new Tag("stream"), new Tag("java") };
					setTags(Arrays.asList(ts));
					setVotes(p * 3);
					setViews(p * 5);
					setCreatedBy(new User() {
						{
							setId("fred");
							setName("Fred");
						}
					});
					setCreatedAt(new Date());
					setAnswersCount(0);
				}
			};
			break;
		}
		questions.add(q);
	}

}
