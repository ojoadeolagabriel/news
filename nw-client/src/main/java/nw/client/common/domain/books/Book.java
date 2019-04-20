package nw.client.common.domain.books;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	private String isbn;
	private String author;
	private String title;
	private String synopsis;
	private String language;
}
