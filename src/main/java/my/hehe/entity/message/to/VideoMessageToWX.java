package my.hehe.entity.message.to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.entity.message.from.MessageFromWX;
import my.hehe.util.WXType;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class VideoMessageToWX extends MessageToWX {
	@XmlElement(name = "Video")
	private final Video Video = new Video();

	public void setMediaId(String mediaId) {
		Video.setMediaId(mediaId);
	}

	public String getMediaId() {
		return Video.getMediaId();
	}

	public String getTitle() {
		return Video.getTitle();
	}

	public String getDescription() {
		return Video.getDescription();
	}

	public void setTitle(String title) {
		Video.setTitle(title);
	}

	public void setDescription(String description) {
		Video.setDescription(description);
	}
	
	public void setVideoInfo(String MediaId,String Title,String Description){
		Video.setTitle(Title);
		Video.setDescription(Description);
		Video.setMediaId(MediaId);
	}

	public VideoMessageToWX() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VideoMessageToWX(MessageFromWX msg, Long createTime) {
		super(msg, createTime, WXType.VIDEO);

		// TODO Auto-generated constructor stub
	}

	public VideoMessageToWX(MessageFromWX msg) {
		super(msg, WXType.VIDEO);
		// TODO Auto-generated constructor stub
	}

	public VideoMessageToWX(String toUserName, String fromUserName,
			Long createTime) {
		super(toUserName, fromUserName, createTime, WXType.VIDEO);
		// TODO Auto-generated constructor stub
	}

	public VideoMessageToWX(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, WXType.VIDEO);
		// TODO Auto-generated constructor stub
	}

}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Video {
	@XmlElement(name = "MediaId")
	private String MediaId;
	@XmlElement(name = "Title")
	private String Title;
	@XmlElement(name = "Description")
	private String Description;

	public String getMediaId() {
		return MediaId;
	}

	public String getTitle() {
		return Title;
	}

	public String getDescription() {
		return Description;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setDescription(String description) {
		Description = description;
	}

}