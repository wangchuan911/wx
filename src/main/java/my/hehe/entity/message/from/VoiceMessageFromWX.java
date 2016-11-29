package my.hehe.entity.message.from;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.util.WXType;

@XmlRootElement(name = "xml")
public class VoiceMessageFromWX extends MessageFromWX {
	private String MediaId;
	private String Format;
	private String Recognition;

	@XmlElementWrapper(name = "Voice")
	@XmlElement(name = "MediaId")
	public String[] getMediaIds() {
		String[] values = { MediaId };
		return values;
	}

	public String getMediaId() {
		return MediaId;
	}

	public String getFormat() {
		return Format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

	public VoiceMessageFromWX() {
		// TODO Auto-generated constructor stub
		MsgType = WXType.MSG_TYPE_VOICE;
	}
}
