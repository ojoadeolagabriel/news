package nw.client.common;

import lombok.Data;

@Data
public class Book {
	private final String isbn;
	private final String author;
	private final String title;
	private final String synopsis;
	private final String language;
}
