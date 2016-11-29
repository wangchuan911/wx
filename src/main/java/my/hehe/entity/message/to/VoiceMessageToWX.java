package my.hehe.entity.message.to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.entity.message.from.MessageFromWX;
import my.hehe.util.WXType;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class VoiceMessageToWX extends MessageToWX {
	@XmlElement(name = "Voice")
	private final Voice Voice = new Voice();

	public void setMediaId(String mediaId) {
		Voice.setMediaId(mediaId);
	}

	public String getMediaId() {
		return Voice.getMediaId();
	}

	public VoiceMessageToWX() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VoiceMessageToWX(MessageFromWX msg, Long createTime) {
		super(msg, createTime, WXType.MSG_TYPE_VOICE);

		// TODO Auto-generated constructor stub
	}

	public VoiceMessageToWX(MessageFromWX msg) {
		super(msg, WXType.MSG_TYPE_VOICE);
		// TODO Auto-generated constructor stub
	}

	public VoiceMessageToWX(String toUserName, String fromUserName,
			Long createTime) {
		super(toUserName, fromUserName, createTime, WXType.MSG_TYPE_VOICE);
		// TODO Auto-generated constructor stub
	}

	public VoiceMessageToWX(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, WXType.MSG_TYPE_VOICE);
		// TODO Auto-generated constructor stub
	}

}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Voice {
	@XmlElement(name = "MediaId")
	private String MediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}