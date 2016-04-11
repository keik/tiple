package info.keik.tiple.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.keik.tiple.model.Answer;
import info.keik.tiple.repository.AnswerRepository;
import info.keik.tiple.service.AnswerService;
import info.keik.tiple.service.QuestionService.AlreadyVotedException;

@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	AnswerRepository answerRepository;

	@Override
	public List<Answer> getByQuestionId(Integer id) {
		return answerRepository.getByQuestionId(id);
	}

	@Override
	public void add(Answer answer) {
		answerRepository.add(answer);
	}

	@Override
	public void vote(Integer answerId, String userId, Integer value) throws AlreadyVotedException {
		Integer v = answerRepository.getVote(answerId, userId);
		if (v != null && v != 0) {
			throw new AlreadyVotedException();
		}
		answerRepository.updateVote(answerId, userId, value);
	}

	@Override
	public void unvote(Integer answerId, String userId) {
		answerRepository.updateVote(answerId, userId, 0);
	}

	@Override
	public Integer getVote(Integer answerId, String userId) {
		return answerRepository.getVote(answerId, userId);
	}

}
