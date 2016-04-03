package info.keik.tiple.controller;

import info.keik.tiple.model.Answer;
import info.keik.tiple.model.User;
import info.keik.tiple.service.AnswerService;
import info.keik.tiple.service.UserService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/q/{questionId}/answers")
public class AnswerController {

	@Autowired
	MessageSource msg;

	@Autowired
	AnswerService answerService;

	@Autowired
	UserService userService;

	@RequestMapping
	public String create(
			Principal principal,
			Answer answer,
			@PathVariable("questionId") Integer questionId) {
		if (principal == null) {
			// TODO
			// return new
			// ResponseEntity<>(msg.getMessage("msg.answer.unauthorized", null,
			// Locale.ENGLISH), HttpStatus.UNAUTHORIZED);
			throw new RuntimeException("TODO");
		}

		User user = userService.get(principal.getName());
		answer.setCreatedBy(user);
		answer.setAnswerFor(questionId);
		answerService.add(answer);
		return "redirect:/q/" + questionId;
	}

}
