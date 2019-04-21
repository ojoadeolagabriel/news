package nw.processor.client.contract;

import feign.FeignException;
import feign.RetryableException;
import nw.client.common.domain.books.BookResource;

import static java.lang.System.out;


public class BookClientFallback implements BookClient {

	private final Throwable cause;

	BookClientFallback(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public BookResource findByIsbn(String isbn) {
		if (cause instanceof FeignException && ((FeignException) cause).status() == 404) {
			out.println("could not complete, received: " + ((FeignException) cause).status());
		} else if (cause instanceof RetryableException) {
			out.println("possible connection issue: " + cause.getMessage());
		} else {
			out.println("issue detected calling while //findByIsbn: " + cause.getMessage());
			cause.printStackTrace();
		}
		return new BookResource(null, null);
	}
}
