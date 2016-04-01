package info.keik.tiple.controller;

import info.keik.tiple.service.AnswerService;
import info.keik.tiple.service.QuestionService;
import info.keik.tiple.service.UserService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class VoteController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/questions/{qid}/votes", method = RequestMethod.POST)
	public ResponseEntity<String> createToQuestion(
			@AuthenticationPrincipal Principal principal,
			@PathVariable("qid") Integer qid,
			Model model
			) {
		questionService.voteUp(qid, principal.getName());
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/questions/{qid}/votes/{uid}", method = RequestMethod.DELETE)
	public ResponseEntity<String> destroyFromQuestion(
			@AuthenticationPrincipal Principal principal,
			@PathVariable("qid") Integer qid,
			@PathVariable("uid") Integer uid,
			Model model
			) {
		questionService.voteDown(qid, principal.getName());
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@RequestMapping(value = "/answers/{aid}/votes", method = RequestMethod.POST)
	public ResponseEntity<String> createToAnswer(
			@AuthenticationPrincipal Principal principal,
			@PathVariable("aid") Integer aid,
			Model model
			) {
		answerService.voteUp(aid, principal.getName());
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/answers/{aid}/votes/{uid}", method = RequestMethod.DELETE)
	public ResponseEntity<String> destroyFromAnswer(
			@AuthenticationPrincipal Principal principal,
			@PathVariable("aid") Integer aid,
			@PathVariable("uid") Integer uid,
			Model model
			) {
		answerService.voteDown(aid, principal.getName());
		return new ResponseEntity<String>(HttpStatus.OK);
	}

}
