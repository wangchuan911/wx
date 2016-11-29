package my.hehe.entity.message.from;

import my.hehe.util.WXType;


public class LinkMessageFromWX extends MessageFromWX {
	private String Title;
	private String Description;
	private String Url;
	public String getTitle() {
		return Title;
	}
	public String getDescription() {
		return Description;
	}
	public String getUrl() {
		return Url;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public void setUrl(String url) {
		Url = url;
	}
	public LinkMessageFromWX() {
		MsgType=WXType.MSG_TYPE_LINK;
	}
	

}
