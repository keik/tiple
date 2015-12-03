package info.keik.tiple.controller;

import info.keik.tiple.model.Question;
import info.keik.tiple.service.QuestionService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/q")
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		List<Question> questions = questionService.getAll();
		model.addAttribute("questions", questions);
		return "questions.html";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Integer id, Model model) {
		Question question = questionService.get(id);
		model.addAttribute("question", question);
		return "question.html";
	}

}
