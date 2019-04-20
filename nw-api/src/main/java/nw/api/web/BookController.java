package nw.api.web;

import io.micrometer.core.annotation.Timed;
import nw.client.common.domain.books.Book;
import nw.client.common.domain.books.BookResource;
import nw.client.common.domain.books.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	@Timed(description = "book_controller", extraTags = {"key", "find_by_isbn"})
	@GetMapping(value = "/{isbn}")
	public BookResource findByIsbn(@PathVariable(value = "isbn") String isbn) {
		return BookResource.builder()
				.book(Book.builder()
						.author("ojo_adeola_gabriel")
						.isbn(isbn)
						.language("en")
						.synopsis("fishing out the culprit")
						.title("ego is the enemy")
						.build())
				.links(Collections.singletonList(new Link("self", "/api/v1/books/" + isbn))).build();
	}
}
