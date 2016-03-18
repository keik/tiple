package info.keik.tiple.model;

import lombok.Data;

@Data
public class Tag {

	private String name;

	public Tag() {
	}

	public Tag(String name) {
		this.name = name;
	}

}
