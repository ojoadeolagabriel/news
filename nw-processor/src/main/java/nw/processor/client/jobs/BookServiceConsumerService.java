package nw.processor.client.jobs;

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
	void run(){
		BookResource bookResource = bookClient.findByIsbn("PKB-1011-1");
		out.println(bookResource.toString());
	}
}
