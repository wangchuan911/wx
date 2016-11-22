package my.hehe.entity.message.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.entity.message.Message4WX;
import my.hehe.util.WXType;

@XmlRootElement(name = "xml")
public class ImageMessage4WX extends Message4WX{

	private String PicUrl;
	private String MediaId;
	
	public String getPicUrl() {
		return PicUrl;
	}

	public String getMediaId() {
		return MediaId;
	}
	
	@XmlElementWrapper(name="Image")
	@XmlElement(name="MediaId")
	public String[] getMediaIds(){
		String[] ids={MediaId};
		return ids;		
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}


	public ImageMessage4WX() {
		this.setMsgType(WXType.IMAGE);
	}

	public ImageMessage4WX(String toUserName, String fromUserName,
			Long createTime,String msgId,String picUrl, String mediaId) {
		super(toUserName, fromUserName, createTime, WXType.IMAGE, msgId);
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
