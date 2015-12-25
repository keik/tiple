package info.keik.tiple.service.impl;

import info.keik.tiple.model.Answer;
import info.keik.tiple.repository.AnswerRepository;
import info.keik.tiple.service.AnswerService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	AnswerRepository answerRepository;

	@Override
	public List<Answer> getByQuestionsId(Integer id) {
		return answerRepository.getByQuestionsId(id);
	}

	@Override
	public void add(Answer answer) {
		answerRepository.add(answer);
	}

}
