package info.keik.tiple.model;

import java.util.Date;

public class Question {

	public Integer id;
	public String title;
	public String content;
	public Date createdAt;
	public Date updatedAt;

	public Question() {
	}

	public Question(String title, String content) {
		this.title = title;
		this.content = content;
	}

}
