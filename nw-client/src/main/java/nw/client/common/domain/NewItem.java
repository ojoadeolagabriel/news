package nw.client.common.domain;

import lombok.Data;

@Data
public class NewItem {
	private final String title;
	private final String subTitle;
	private final String moreInformation;
	private final String body;
	private final NewsItemImage newsItemImage;
}
