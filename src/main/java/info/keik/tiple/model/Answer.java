package info.keik.tiple.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Answer {

	private Integer refQuestionId;
	private String content;
	private User createdBy;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public Answer() {
	}

}
