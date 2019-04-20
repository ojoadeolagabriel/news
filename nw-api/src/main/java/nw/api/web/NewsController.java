package nw.api.web;

import nw.api.domain.NewsItemResource;
import nw.client.common.Link;
import nw.client.common.domain.NewItem;
import nw.client.common.domain.NewsItemImage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/news")
public class NewsController {

	@GetMapping(value = "/{time-stamp}", produces = "application/json")
	public List<NewsItemResource> fetchNewsByTimestamp(@PathVariable(value = "time-stamp") String timeStamp, HttpServletResponse response) {
		response.addHeader("article-timestamp", timeStamp);
		return Stream.of(
				new NewsItemResource(new NewItem("Trump", "Daily Telegraph", "", "Muller report",
						new NewsItemImage("img_1", "http://tw.e4Ty4/im_2")), new Link("", "")),
				new NewsItemResource(new NewItem("Michelle", "Daily Poll", "", "Missing food",
						new NewsItemImage("img_2", "http://tw.e4Ty421/imd_2")), new Link("", ""))
		).collect(Collectors.toList());
	}
}
