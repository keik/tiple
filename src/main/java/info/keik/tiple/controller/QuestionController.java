package info.keik.tiple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/q")
public class QuestionController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "tickets.html";
	}

}
