package nw.processor.client.jobs;

import io.micrometer.core.annotation.Timed;
import lombok.AllArgsConstructor;
import nw.client.common.domain.books.BookResource;
import nw.processor.client.contract.BookClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

import static java.lang.System.out;

@Service
@AllArgsConstructor
public class BookServiceConsumerService {

	BookClient bookClient;

	@Scheduled(fixedDelay = 2000)
	void run() {
		out.println(process());
	}

	@Timed(value = "book_service_consumer", extraTags = {"action", "fetch_book_resource"})
	private BookResource process() {
		out.println("running....");
		return bookClient.findByIsbn("PKB-1011-1-" + new Date().getTime());
	}
}
