package info.keik.tiple.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.keik.tiple.model.Question;
import info.keik.tiple.repository.QuestionRepository;
import info.keik.tiple.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepository questionRepository;

	@Override
	public Question get(Integer id) {
		return questionRepository.get(id);
	}

	@Override
	public Question add(Question question) {
		questionRepository.add(question);
		return question;
	}

	@Override
	public Integer getTotalCount(String tagName) {
		return questionRepository.count(tagName);
	}

	@Override
	public List<Question> search(String tagName, Integer page, Integer pageSize) {
		return questionRepository.search(tagName, (page - 1) * pageSize, pageSize);
	}

	@Override
	public void addViewsCount(Integer id) {
		questionRepository.addViewsCount(id);
	}

	@Override
	public void vote(Integer questionId, String userId, Integer value) throws AlreadyVotedException {
		Integer v = questionRepository.getVote(questionId, userId);
		if (v != null && v != 0) {
			throw new AlreadyVotedException();
		}
		questionRepository.updateVote(questionId, userId, value);
	}

	@Override
	public void unvote(Integer questionId, String userId) {
		questionRepository.updateVote(questionId, userId, 0);
	}

	@Override
	public Integer getVote(Integer questionId, String userId) {
		return questionRepository.getVote(questionId, userId);
	}

}
