package info.keik.tiple.service.impl;

import info.keik.tiple.model.Tag;
import info.keik.tiple.service.TagService;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

	@Override
	public List<Tag> getAll() {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public Map<Tag, Integer> getAllWithTaggedNumbers() {
		throw new RuntimeException("Not implemented");
	}

}
