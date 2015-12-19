package info.keik.tiple.controller;

import info.keik.tiple.model.Answer;
import info.keik.tiple.service.AnswerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/q/{questionId}/answers")
public class AnswerController {

	@Autowired
	AnswerService answerService;

	@RequestMapping
	public ResponseEntity<String> create(Answer answer, @PathVariable("questionId") Integer questionId) {
		answer.setRefQuestionId(questionId);
		answerService.add(answer);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
