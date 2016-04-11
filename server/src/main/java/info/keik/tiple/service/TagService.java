package info.keik.tiple.service;

import java.util.List;
import java.util.Map;

import info.keik.tiple.model.Tag;

public interface TagService {

	/**
	 * Return all tags.
	 * 
	 * @return all tags
	 */
	List<Tag> getAll();

	/**
	 * Return all tags with tagged numbers.
	 * 
	 * @return all tags
	 */
	Map<Tag, Integer> getAllWithTaggedNumbers();

}
