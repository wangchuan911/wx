package my.hehe.entity.message.send.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.util.WXType;

@XmlRootElement(name = "xml")
public class ImageMessage4WX extends Message4WX{

	private String PicUrl;
	private String MediaId;
	
	
	

	@XmlElement(name="PicUrl")
	public String getPicUrl() {
		return PicUrl;
	}
	@XmlElement(name="MediaId")
	public String getMediaId() {
		return MediaId;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	@XmlElement(name="ToUserName")
	@Override
	public String getToUserName() {
		// TODO Auto-generated method stub
		return super.getToUserName();
	}

	@Override
	public void setToUserName(String toUserName) {
		// TODO Auto-generated method stub
		super.setToUserName(toUserName);
	}
	@XmlElement(name="FromUserName")
	@Override
	public String getFromUserName() {
		// TODO Auto-generated method stub
		return super.getFromUserName();
	}

	@Override
	public void setFromUserName(String fromUserName) {
		// TODO Auto-generated method stub
		super.setFromUserName(fromUserName);
	}
	@XmlElement(name="CreateTime")
	@Override
	public Long getCreateTime() {
		// TODO Auto-generated method stub
		return super.getCreateTime();
	}

	@Override
	public void setCreateTime(Long createTime) {
		// TODO Auto-generated method stub
		super.setCreateTime(createTime);
	}
	@XmlElement(name="MsgType")
	@Override
	public String getMsgType() {
		// TODO Auto-generated method stub
		return super.getMsgType();
	}

//	@Override
//	public void setMsgType(String msgType) {
//		// TODO Auto-generated method stub
//		super.setMsgType(msgType);
//	}
	@XmlElement(name="MsgId")
	@Override
	public String getMsgId() {
		// TODO Auto-generated method stub
		return super.getMsgId();
	}

	@Override
	public void setMsgId(String msgId) {
		// TODO Auto-generated method stub
		super.setMsgId(msgId);
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
