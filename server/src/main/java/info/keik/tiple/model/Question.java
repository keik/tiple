package info.keik.tiple.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class Question {

	private Integer id;
	private String title;
	private String content;
	private List<Tag> tags;
	private Integer viewsCount;
	private Integer votesCount;
	private Integer answersCount;
	private User createdBy;
	private Date createdAt;
	private Date updatedAt;
	private Integer yourVoteValue;

	public Question() {
	}

	public Question(String title, String content) {
		this.title = title;
		this.content = content;
	}

}