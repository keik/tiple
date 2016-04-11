package info.keik.tiple.model;

import java.util.Date;

import lombok.Data;

@Data
public class Answer {

	private Integer id;
	private String content;
	private Integer answerFor;
	private Integer votesCount;
	private User createdBy;
	private Date createdAt;
	private Date updatedAt;
	private Integer yourVoteValue;

	public Answer() {
	}

}
