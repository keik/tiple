package info.keik.tiple.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import info.keik.tiple.service.AnswerService;
import info.keik.tiple.service.QuestionService;
import info.keik.tiple.service.QuestionService.AlreadyVotedException;

@RestController
@RequestMapping("/")
public class VoteController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@RequestMapping(value = "/q/{qid}/votes", method = RequestMethod.POST)
	public ResponseEntity<String> createToQuestion(
			@AuthenticationPrincipal Principal principal,
			@PathVariable("qid") Integer qid,
			@RequestParam("v") Integer v,
			Model model) {
		if (principal == null)
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		try {
			if (v == 1 || v == -1)
				questionService.vote(qid, principal.getName(), v);
			else
				new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} catch (AlreadyVotedException e) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/q/{qid}/votes", method = RequestMethod.DELETE)
	public ResponseEntity<String> destroyFromQuestion(
			@AuthenticationPrincipal Principal principal,
			@PathVariable("qid") Integer qid,
			Model model) {
		if (principal == null)
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		questionService.unvote(qid, principal.getName());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/q/{qid}/a/{aid}/votes", method = RequestMethod.POST)
	public ResponseEntity<String> createToAnswer(
			@AuthenticationPrincipal Principal principal,
			@PathVariable("aid") Integer aid,
			@RequestParam("v") Integer value,
			Model model) {
		if (principal == null)
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		answerService.voteUp(aid, principal.getName());
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/q/{qid}/a/{aid}/votes", method = RequestMethod.DELETE)
	public ResponseEntity<String> destroyFromAnswer(
			@AuthenticationPrincipal Principal principal,
			@PathVariable("aid") Integer aid,
			Model model) {
		if (principal == null)
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		questionService.unvote(aid, principal.getName());
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
