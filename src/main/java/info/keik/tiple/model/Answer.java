package info.keik.tiple.model;

import java.util.Date;

import lombok.Data;

@Data
public class Answer {

	private String content;
	private User createdBy;
	private Date createdAt;
	private Date updatedAt;

	public Answer() {
	}

}
