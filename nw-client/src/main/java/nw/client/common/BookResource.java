package nw.client.common;

import lombok.Data;

import java.util.List;

@Data
public class BookResource {
	private final Book book;
	private final List<Link> links;
}
