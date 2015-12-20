package info.keik.tiple.model;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class Question {

	private Integer id;
	private String title;
	private String content;
	private List<Tag> tags;
	private User createdBy;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public Question() {
	}

	public Question(String title, String content) {
		this.title = title;
		this.content = content;
	}

}
