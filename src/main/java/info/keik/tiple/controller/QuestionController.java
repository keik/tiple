package info.keik.tiple.controller;

import info.keik.tiple.model.Answer;
import info.keik.tiple.model.Question;
import info.keik.tiple.model.User;
import info.keik.tiple.service.AnswerService;
import info.keik.tiple.service.QuestionService;
import info.keik.tiple.service.UserService;

import java.security.Principal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/q")
public class QuestionController {

	private static final Logger logger = LoggerFactory.getLogger(QuestionController.class);

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, @RequestParam(value = "tag", required = false) String tagName) {
		List<Question> questions = tagName == null
				? questionService.getAll()
				: questionService.getByTag(tagName);
		model.addAttribute("questions", questions);
		return "questions/index.html";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Integer id, Model model) {
		Question question = questionService.get(id);
		List<Answer> answers = answerService.getByQuestionsId(id);
		model.addAttribute("question", question);
		model.addAttribute("answers", answers);
		return "questions/show.html";
	}

	@RequestMapping(value = "/ask", method = RequestMethod.GET)
	public String _new(Model model) {
		return "questions/ask.html";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(Principal principal, Model model, Question question) {
		if (principal == null) {
			throw new RuntimeException("authentication required.");
		}

		User user = userService.getById(principal.getName());
		question.setCreatedBy(user);
		questionService.add(question);
		return "redirect:/q";
	}

}
