package nw.processor.client.contract;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class BookClientFallbackFactory implements FallbackFactory<BookClient> {
	@Override
	public BookClient create(Throwable cause) {
		return new BookClientFallback(cause);
	}
}
