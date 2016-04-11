package info.keik.tiple.service.mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.keik.tiple.model.Answer;
import info.keik.tiple.model.User;
import info.keik.tiple.service.AnswerService;
import info.keik.tiple.service.QuestionService;

@Service
public class AnswerServiceMock implements AnswerService {

	@Autowired
	QuestionService questionService;

	public List<Answer> answers = new ArrayList<>();

	{
		for (int i = 0; i < 4; i++) {
			addDummyAnswer(i % 3);
		}
	}

	@Override
	public List<Answer> getByQuestionId(Integer id) {
		return answers.stream()
				.collect(Collectors.toList());
	}

	@Override
	public void add(Answer answer) {
		answer.setCreatedAt(new Date());
		answers.add(answer);
	}

	@Override
	public void vote(Integer answerId, String userId, Integer value) {
		Answer answer = answers.stream()
				.filter(a -> answerId == a.getId())
				.findAny().get();
		answer.setVotesCount(answer.getVotesCount() + value);
	}

	@Override
	public void unvote(Integer answerId, String userId) {
		// TODO
	}

	private void addDummyAnswer(Integer p) {
		Answer a = null;
		switch (p) {
		case 0:
			a = new Answer() {
				{
					setId(answers.size() + 1);
					setContent("Ad quem hinc patrioque pri, in agam homero semper vel, nibh facer libris ne ius. An usu mollis iuvaret, eum veritus consectetuer id, ei latine feugait duo. Et vero volutpat nec. Id tale interesset eos, at pri impetus dolores antiopam. At vis erat timeam eligendi, id vis omnesque tincidunt efficiendi.");
					setVotesCount(p * 3);
					setCreatedBy(new User() {
						{
							setId("alice");
							setName("Alice");
						}
					});
					setCreatedAt(new Date());
				}
			};
			break;
		case 1:
			a = new Answer() {
				{
					setId(answers.size() + 1);
					setContent("Et usu graece omittam voluptua, has ei viderer fastidii. Vix omnis iudico eu. Usu ad mandamus expetendis, ad eam sumo clita evertitur. Id his latine tacimates.");
					setVotesCount(p * 3);
					setCreatedBy(new User() {
						{
							setId("alice");
							setName("Alice");
						}
					});
					setCreatedAt(new Date());
				}
			};
			break;
		case 2:
			a = new Answer() {
				{
					setId(answers.size() + 1);
					setContent("Usu populo sententiae ad. Vivendo detracto principes mei te, fabulas contentiones ne his. Eu repudiare vituperatoribus duo, ne his dicunt singulis, altera viderer ei nam. Usu timeam sensibus at, corpora suscipit ex usu. Ea congue aliquando vel, agam viderer cu eum, mel eirmod atomorum cu.");
					setVotesCount(p * 3);
					setCreatedBy(new User() {
						{
							setId("alice");
							setName("Alice");
						}
					});
					setCreatedAt(new Date());
				}
			};
		}
		answers.add(a);
	}

	@Override
	public Integer getVote(Integer answerId, String userId) {
		// TODO Auto-generated method stub
		return null;
	}
}
