package info.keik.tiple.model;

import java.util.Date;
import java.util.List;

public class Question {

	public Integer id;
	public String title;
	public String content;
	public List<Tag> tags;
	public Date createdAt;
	public Date updatedAt;

	public Question() {
	}

	public Question(String title, String content) {
		this.title = title;
		this.content = content;
	}

}
