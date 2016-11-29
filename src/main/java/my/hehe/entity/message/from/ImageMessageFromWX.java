package my.hehe.entity.message.from;

import my.hehe.util.WXType;


public class ImageMessageFromWX extends MessageFromWX{

	private String PicUrl;
	private String MediaId;
	
	public String getPicUrl() {
		return PicUrl;
	}

	public String getMediaId() {
		return MediaId;
	}
	

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}


	public ImageMessageFromWX() {
		this.setMsgType(WXType.MSG_TYPE_IMAGE);
	}

	public ImageMessageFromWX(String toUserName, String fromUserName,
			Long createTime,String msgId,String picUrl, String mediaId) {
		super(toUserName, fromUserName, createTime, WXType.MSG_TYPE_IMAGE, msgId);
		this.PicUrl = picUrl;
		this.MediaId = mediaId;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{\"PicUrl\":\"");
		builder.append(PicUrl);
		builder.append("\", \"MediaId\":\"");
		builder.append(MediaId);
		builder.append("\", \"ToUserName\":\"");
		builder.append(ToUserName);
		builder.append("\", \"FromUserName\":\"");
		builder.append(FromUserName);
		builder.append("\", \"CreateTime\":\"");
		builder.append(CreateTime);
		builder.append("\", \"MsgType\":\"");
		builder.append(MsgType);
		builder.append("\", \"MsgId\":\"");
		builder.append(MsgId);
		builder.append("\"]");
		return builder.toString();
	}




}
