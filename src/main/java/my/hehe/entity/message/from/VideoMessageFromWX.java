package my.hehe.entity.message.from;

import my.hehe.util.WXType;


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
	public VideoMessageFromWX() {
		// TODO Auto-generated constructor stub
		MsgType=WXType.MSG_TYPE_VIDEO;
	}

}
