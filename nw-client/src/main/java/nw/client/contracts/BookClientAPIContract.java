package nw.client.contracts;

import nw.client.common.domain.books.BookResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface BookClientAPIContract {
	@GetMapping(value = "/{isbn}")
	BookResource findByIsbn(@PathVariable("isbn") String isbn);
}
