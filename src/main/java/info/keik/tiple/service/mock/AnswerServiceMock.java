package info.keik.tiple.service.mock;

import info.keik.tiple.model.Answer;
import info.keik.tiple.model.User;
import info.keik.tiple.service.AnswerService;
import info.keik.tiple.service.QuestionService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceMock implements AnswerService {

	@Autowired
	QuestionService questionService;

	public List<Answer> answers = new ArrayList<>();

	{
		answers.add(new Answer() {
			{
				setContent("Ad quem hinc patrioque pri, in agam homero semper vel, nibh facer libris ne ius. An usu mollis iuvaret, eum veritus consectetuer id, ei latine feugait duo. Et vero volutpat nec. Id tale interesset eos, at pri impetus dolores antiopam. At vis erat timeam eligendi, id vis omnesque tincidunt efficiendi.");
				setCreatedBy(new User() {
					{
						setId("alice");
						setName("Alice");
					}
				});
				setCreatedAt(new Date());
			}
		});
		answers.add(new Answer() {
			{
				setContent("Et usu graece omittam voluptua, has ei viderer fastidii. Vix omnis iudico eu. Usu ad mandamus expetendis, ad eam sumo clita evertitur. Id his latine tacimates.");
				setCreatedBy(new User() {
					{
						setId("alice");
						setName("Alice");
					}
				});
				setCreatedAt(new Date());
			}
		});
		answers.add(new Answer() {
			{
				setContent("Usu populo sententiae ad. Vivendo detracto principes mei te, fabulas contentiones ne his. Eu repudiare vituperatoribus duo, ne his dicunt singulis, altera viderer ei nam. Usu timeam sensibus at, corpora suscipit ex usu. Ea congue aliquando vel, agam viderer cu eum, mel eirmod atomorum cu.");
				setCreatedBy(new User() {
					{
						setId("alice");
						setName("Alice");
					}
				});
				setCreatedAt(new Date());
			}
		});
	}

	@Override
	public List<Answer> getByQuestionsId(Integer id) {
		return answers.stream()
				.collect(Collectors.toList());
	}

	@Override
	public void add(Answer answer) {
		answer.setCreatedAt(new Date());
		answers.add(answer);
	}

}
