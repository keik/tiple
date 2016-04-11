package info.keik.tiple.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import info.keik.tiple.model.Tag;
import info.keik.tiple.service.TagService;

@Controller
@RequestMapping("/tags")
public class TagController {

	@Autowired
	private TagService tagService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		Map<Tag, Integer> tagsWithTaggedNumbers = tagService.getAllWithTaggedNumbers();
		model.addAttribute("tagsWithTaggedNumbers", tagsWithTaggedNumbers);
		return "tags/index.html";
	}

}
