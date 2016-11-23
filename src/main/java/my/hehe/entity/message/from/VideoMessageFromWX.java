package my.hehe.entity.message.from;


public class VideoMessageFromWX extends MessageFromWX{
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
