package my.hehe.entity.message.xml;

import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.entity.message.Message4WX;

@XmlRootElement(name = "xml")
public class LinkMessage4WX extends Message4WX {
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
	
	

}
