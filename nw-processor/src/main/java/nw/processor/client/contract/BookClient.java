package nw.processor.client.contract;

import nw.client.contracts.BookClientX;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "bookClient", name = "bookClient", url = "http://localhost:5051/api/v1/books", fallbackFactory = BookClientFallbackFactory.class)
public interface BookClient extends BookClientX {

}

