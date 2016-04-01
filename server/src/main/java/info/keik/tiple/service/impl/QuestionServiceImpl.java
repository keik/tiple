package info.keik.tiple.service.impl;

import info.keik.tiple.model.Question;
import info.keik.tiple.repository.QuestionRepository;
import info.keik.tiple.service.QuestionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void voteUp(Integer questionId, String userId) {
		Integer v = questionRepository.getVote(questionId, userId);
		if (v != null && v == 1) {
			throw new RuntimeException("TODO Already voted");
		}
		questionRepository.updateVote(questionId, userId, 1);
	}

	@Override
	public void voteDown(Integer questionId, String userId) {
		Integer v = questionRepository.getVote(questionId, userId);
		if (v != null && v == -1) {
			throw new RuntimeException("TODO Already voted down");
		}
		questionRepository.updateVote(questionId, userId, -1);
	}

	@Override
	public void unvote(Integer questionId, String userId) {
		questionRepository.updateVote(questionId, userId, 0);
	}

}
