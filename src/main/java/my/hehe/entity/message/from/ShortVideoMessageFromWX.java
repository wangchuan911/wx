package my.hehe.entity.message.from;

import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.util.WXType;

@XmlRootElement(name = "xml")
public class ShortVideoMessageFromWX extends MessageFromWX{
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
	public ShortVideoMessageFromWX() {
		// TODO Auto-generated constructor stub
		MsgType=WXType.MSG_TYPE_SHORT_VIDEO;
	}

}
