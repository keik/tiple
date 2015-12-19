package info.keik.tiple.model;

import java.util.Date;

import lombok.Data;

@Data
public class Answer {

	private Integer refQuestionId;
	private String content;
	private Date createdAt;
	private Date updatedAt;

	public Answer() {
	}

}
