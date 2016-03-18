package info.keik.tiple.service.mock;

import info.keik.tiple.model.Tag;
import info.keik.tiple.service.QuestionService;
import info.keik.tiple.service.TagService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceMock implements TagService {

	@Autowired
	QuestionService questionService;

	public List<Tag> tags = new ArrayList<>();

	{
		tags.add(new Tag() {
			{
				setName("javascript");
			}
		});
		tags.add(new Tag() {
			{
				setName("node");
			}
		});
		tags.add(new Tag() {
			{
				setName("java");
			}
		});
		tags.add(new Tag() {
			{
				setName("maven");
			}
		});
	}

	@Override
	public List<Tag> getAll() {
		return tags;
	}

	@Override
	public Map<Tag, Integer> getAllWithTaggedNumbers() {
		return tags.stream()
				.collect(Collectors.toMap(
						t -> t,
						t -> questionService.getByTag(t).size()));
	}

}
