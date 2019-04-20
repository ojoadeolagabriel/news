package nw.api.domain;

import lombok.Data;
import nw.client.common.domain.books.Link;
import nw.client.common.domain.news.NewItem;

@Data
public class NewsItemResource {
	private final NewItem body;
	private final Link links;
}
