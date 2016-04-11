package info.keik.tiple.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.keik.tiple.model.Answer;
import info.keik.tiple.repository.AnswerRepository;
import info.keik.tiple.service.AnswerService;

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
	public void voteUp(Integer answerId, String userId) {
		Integer v = answerRepository.getVote(answerId, userId);
		if (v != null && v == 1) {
			throw new RuntimeException("TODO Already voted up");
		}
		answerRepository.updateVote(answerId, userId, 1);
	}

	@Override
	public void voteDown(Integer answerId, String userId) {
		Integer v = answerRepository.getVote(answerId, userId);
		if (v != null && v == -1) {
			throw new RuntimeException("TODO Already voted down");
		}
		answerRepository.updateVote(answerId, userId, -1);
	}

	@Override
	public void unvote(Integer answerId, String userId) {
		answerRepository.updateVote(answerId, userId, 0);
	}

}
