package info.keik.tiple.model;

import java.util.Date;

import lombok.Data;

@Data
public class Comment {

	private Integer id;
	private String content;
	private Date privatedAt;
	private Date updatedAt;

	public Comment() {
	}

}
