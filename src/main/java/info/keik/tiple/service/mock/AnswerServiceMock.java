package info.keik.tiple.service.mock;

import info.keik.tiple.controller.QuestionController;
import info.keik.tiple.model.Answer;
import info.keik.tiple.service.AnswerService;

import java.time.LocalDateTime;
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
				setContent("Ad quem hinc patrioque pri, in agam homero semper vel, nibh facer libris ne ius. An usu mollis iuvaret, eum veritus consectetuer id, ei latine feugait duo. Et vero volutpat nec. Id tale interesset eos, at pri impetus dolores antiopam. At vis erat timeam eligendi, id vis omnesque tincidunt efficiendi.");
			}
		});
		answers.add(new Answer() {
			{
				setRefQuestionId(0);
				setContent("Et usu graece omittam voluptua, has ei viderer fastidii. Vix omnis iudico eu. Usu ad mandamus expetendis, ad eam sumo clita evertitur. Id his latine tacimates.");
			}
		});
		answers.add(new Answer() {
			{
				setRefQuestionId(1);
				setContent("Usu populo sententiae ad. Vivendo detracto principes mei te, fabulas contentiones ne his. Eu repudiare vituperatoribus duo, ne his dicunt singulis, altera viderer ei nam. Usu timeam sensibus at, corpora suscipit ex usu. Ea congue aliquando vel, agam viderer cu eum, mel eirmod atomorum cu.");
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
		answer.setCreatedAt(LocalDateTime.now());
		answers.add(answer);
	}

}
