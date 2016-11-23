package my.hehe.entity.message.to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.entity.message.from.MessageFromWX;
import my.hehe.util.WXType;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ImageMessageToWX extends MessageToWX {
	@XmlElement(name = "Image")
	private final Image Image = new Image();

	public void setMediaId(String mediaId) {
		Image.setMediaId(mediaId);
	}

	public String getMediaId() {
		return Image.getMediaId();
	}

	public ImageMessageToWX() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageMessageToWX(MessageFromWX msg, Long createTime) {
		super(msg, createTime, WXType.IMAGE);

		// TODO Auto-generated constructor stub
	}

	public ImageMessageToWX(MessageFromWX msg) {
		super(msg, WXType.IMAGE);
		// TODO Auto-generated constructor stub
	}

	public ImageMessageToWX(String toUserName, String fromUserName,
			Long createTime) {
		super(toUserName, fromUserName, createTime, WXType.IMAGE);
		// TODO Auto-generated constructor stub
	}

	public ImageMessageToWX(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, WXType.IMAGE);
		// TODO Auto-generated constructor stub
	}

}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Image {
	@XmlElement(name = "MediaId")
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}