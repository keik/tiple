package info.keik.tiple.service.impl;

import info.keik.tiple.model.Question;
import info.keik.tiple.model.Tag;
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
	public List<Question> getAll() {
		return questionRepository.getAll();
	}

	@Override
	public Question get(Integer id) {
		return questionRepository.get(id);
	}

	@Override
	public List<Question> getByTag(Tag tag) {
		return questionRepository.getByTag(tag);
	}

	@Override
	public Question add(Question question) {
		questionRepository.add(question);
		return question;
	}

	@Override
	public Integer getTotalCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> search(String tag, Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}
