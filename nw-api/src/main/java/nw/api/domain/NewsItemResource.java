package nw.api.domain;

import lombok.Data;
import nw.client.common.Link;
import nw.client.common.domain.NewItem;

@Data
public class NewsItemResource {
	private final NewItem body;
	private final Link links;
}
