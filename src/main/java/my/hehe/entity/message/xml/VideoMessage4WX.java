package my.hehe.entity.message.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.entity.message.Message4WX;
import my.hehe.util.WXType;

@XmlRootElement(name = "xml")
public class VideoMessage4WX extends Message4WX{
	private String MediaId;
	private String ThumbMediaId;
	public String getMediaId() {
		return MediaId;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
	

}
