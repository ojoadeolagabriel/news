package nw.api.web;

import nw.client.common.Book;
import nw.client.common.BookResource;
import nw.client.common.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	@GetMapping(value = "/{isbn}")
	public BookResource findByIsbn(@PathVariable(value = "isbn") String isbn) {
		return new BookResource(new Book(isbn, "adeola", "lord of the rings", "not ready", "en"),
				Stream.of(new Link("", "")).collect(Collectors.toList()));
	}
}
