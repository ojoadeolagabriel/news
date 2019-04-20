package nw.processor.client.jobs;

import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import nw.client.common.BookResource;
import nw.client.contracts.BookClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import static java.lang.System.out;

@Service
@AllArgsConstructor
public class BookServiceConsumerService {

	BookClient bookClient;

	@Scheduled(fixedDelay = 1000)
	void run() {
		process();
	}

	@Timed(value = "book_service_consumer", extraTags = {"action", "fetch_book_resource"})
	private void process() {
		BookResource bookResource = bookClient.findByIsbn("PKB-1011-1");
		out.println(bookResource.toString());
	}
}
