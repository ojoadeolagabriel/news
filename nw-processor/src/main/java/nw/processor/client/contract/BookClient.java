package nw.processor.client.contract;

import nw.client.contracts.BookClientAPIContract;
import nw.processor.config.BookClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "bookClient",
		url = "${bookClient.url}",
		fallbackFactory = BookClientFallbackFactory.class,
		configuration = BookClientConfig.class)
public interface BookClient extends BookClientAPIContract {

}

