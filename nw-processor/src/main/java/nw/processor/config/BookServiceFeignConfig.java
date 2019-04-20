package nw.processor.config;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;
import nw.client.contracts.BookClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookServiceFeignConfig {

	@Bean
	BookClient bookClient(){
		return Feign.builder()
				.client(new OkHttpClient())
				.encoder(new GsonEncoder())
				.decoder(new GsonDecoder())
				.logger(new Slf4jLogger(BookClient.class))
				.logLevel(Logger.Level.FULL)
				.target(BookClient.class, "http://localhost:5051/api/v1/books");
	}
}
