package info.keik.tiple.controller;

import info.keik.tiple.model.Answer;
import info.keik.tiple.model.User;
import info.keik.tiple.service.AnswerService;
import info.keik.tiple.service.UserService;

import java.security.Principal;

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
	
	@Autowired
	UserService userService;

	@RequestMapping
	public ResponseEntity<String> create(Principal principal, Answer answer, @PathVariable("questionId") Integer questionId) {
		if (principal == null) {
			throw new RuntimeException("authentication required.");
		}

		answer.setRefQuestionId(questionId);
		User user = userService.get(principal.getName());
		answer.setCreatedBy(user);
		answerService.add(answer);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
