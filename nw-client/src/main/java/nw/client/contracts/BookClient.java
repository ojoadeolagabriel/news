package nw.client.contracts;

import feign.Param;
import feign.RequestLine;
import nw.client.common.BookResource;

import java.util.List;

public interface BookClient {
	@RequestLine("GET /{isbn}")
	BookResource findByIsbn(@Param("isbn") String isbn);

	@RequestLine("GET")
	List<BookResource> findAll();
}
