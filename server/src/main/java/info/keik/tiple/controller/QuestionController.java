package info.keik.tiple.controller;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import info.keik.tiple.model.Answer;
import info.keik.tiple.model.Question;
import info.keik.tiple.model.Tag;
import info.keik.tiple.model.User;
import info.keik.tiple.service.AnswerService;
import info.keik.tiple.service.QuestionService;
import info.keik.tiple.service.UserService;

@Controller
@RequestMapping("/q")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private AnswerService answerService;

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model,
			@RequestParam(value = "tag", required = false) String tagName,
			@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
			@RequestParam(value = "page_size", required = false, defaultValue = "10") Integer pageSize) {

		List<Question> questions = questionService.search(tagName, page, pageSize);
		Integer total = questionService.getTotalCount(tagName);

		model.addAttribute("questions", questions);
		model.addAttribute("tag", tagName);
		model.addAttribute("page", page);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("total", total);
		return "questions/index.html";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(
			@PathVariable("id") Integer id,
			@AuthenticationPrincipal Principal principal,
			Model model) {

		questionService.addViewsCount(id);

		Question question = questionService.get(id);
		model.addAttribute("question", question);

		Integer voteForQuestion = principal != null
				? questionService.getVote(id, principal.getName())
				: null;
		model.addAttribute("voteForQuestion", voteForQuestion);

		List<Answer> answers = answerService.getByQuestionId(id);
		model.addAttribute("answers", answers);
		return "questions/show.html";
	}

	@RequestMapping(value = "/ask", method = RequestMethod.GET)
	public String _new(Model model) {
		return "questions/ask.html";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(Principal principal,
			Model model,
			Question question,
			@RequestParam("tags") String tags) {
		if (principal == null) {
			throw new RuntimeException("authentication required.");
		}

		User user = userService.get(principal.getName());
		question.setCreatedBy(user);
		question.setTags(Arrays.asList(tags.split(" "))
				.stream()
				.map(tagName -> new Tag(tagName))
				.collect(Collectors.toList()));
		questionService.add(question);
		return "redirect:/q?";
	}

}
