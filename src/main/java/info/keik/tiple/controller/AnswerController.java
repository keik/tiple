package info.keik.tiple.controller;

import info.keik.tiple.model.Answer;
import info.keik.tiple.model.User;
import info.keik.tiple.service.AnswerService;
import info.keik.tiple.service.UserService;

import java.security.Principal;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/q/{questionId}/answers")
public class AnswerController {

	@Autowired
	MessageSource msg;

	@Autowired
	AnswerService answerService;

	@Autowired
	UserService userService;

	@RequestMapping
	public ResponseEntity<String> create(Principal principal, Answer answer, @PathVariable("questionId") Integer questionId) {
		if (principal == null) {
			return new ResponseEntity<>(msg.getMessage("msg.answer.unauthorized", null, Locale.ENGLISH), HttpStatus.UNAUTHORIZED);
		}

		User user = userService.get(principal.getName());
		answer.setCreatedBy(user);
		answerService.add(answer);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
