package my.hehe.entity.message.to;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.entity.message.from.MessageFromWX;
import my.hehe.util.WXType;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class MusicMessageToWX extends MessageToWX {
	@XmlElement(name = "Music")
	private final Music Music = new Music();

	public String getTitle() {
		return Music.getTitle();
	}

	public String getDescription() {
		return Music.getDescription();
	}

	public String getMusicUrl() {
		return Music.getMusicUrl();
	}

	public String getHQMusicUrl() {
		return Music.getHQMusicUrl();
	}

	public String getThumbMediaId() {
		return Music.getThumbMediaId();
	}

	public void setMusicUrl(String musicUrl) {
		Music.setMusicUrl(musicUrl);
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		Music.setHQMusicUrl(hQMusicUrl);
	}

	public void setThumbMediaId(String thumbMediaId) {
		Music.setThumbMediaId(thumbMediaId);
	}

	public void setTitle(String title) {
		Music.setTitle(title);
	}

	public void setDescription(String description) {
		Music.setDescription(description);
	}

	public void setMusicInfo(String Title, String Description, String MusicUrl,
			String HQMusicUrl, String ThumbMediaId) {
		Music.setTitle(Title);
		Music.setDescription(Description);
		Music.setHQMusicUrl(HQMusicUrl);
		Music.setThumbMediaId(ThumbMediaId);
		Music.setMusicUrl(MusicUrl);
	}

	public MusicMessageToWX() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MusicMessageToWX(MessageFromWX msg, Long createTime) {
		super(msg, createTime, WXType.MUSIC);

		// TODO Auto-generated constructor stub
	}

	public MusicMessageToWX(MessageFromWX msg) {
		super(msg, WXType.MUSIC);
		// TODO Auto-generated constructor stub
	}

	public MusicMessageToWX(String toUserName, String fromUserName,
			Long createTime) {
		super(toUserName, fromUserName, createTime, WXType.MUSIC);
		// TODO Auto-generated constructor stub
	}

	public MusicMessageToWX(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, WXType.MUSIC);
		// TODO Auto-generated constructor stub
	}

}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Music {

	@XmlElement(name = "MediaId")
	private String Title;
	@XmlElement(name = "Description")
	private String Description;
	@XmlElement(name = "MusicUrl")
	private String MusicUrl;
	@XmlElement(name = "HQMusicUrl")
	private String HQMusicUrl;
	@XmlElement(name = "ThumbMediaId")
	private String ThumbMediaId;

	public String getTitle() {
		return Title;
	}

	public String getDescription() {
		return Description;
	}

	public String getMusicUrl() {
		return MusicUrl;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setDescription(String description) {
		Description = description;
	}

}