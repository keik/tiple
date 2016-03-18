package info.keik.tiple.model;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Comment {

	private Integer id;
	private String content;
	private LocalDateTime privatedAt;
	private LocalDateTime updatedAt;

	public Comment() {
	}

}
