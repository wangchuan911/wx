package my.hehe.entity.message.to;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.entity.message.from.MessageFromWX;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class MessageToWX {
	@XmlElement(name = "ToUserName")
	protected String ToUserName;
	@XmlElement(name = "FromUserName")
	protected String FromUserName;
	@XmlElement(name = "CreateTime")
	protected Long CreateTime;
	@XmlElement(name = "MsgType")
	protected String MsgType;

	
	public String getToUserName() {
		return ToUserName;
	}

	
	public String getFromUserName() {
		return FromUserName;
	}

	
	public Long getCreateTime() {
		return CreateTime;
	}

	
	public String getMsgType() {
		return MsgType;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public MessageToWX() {
	}

	public MessageToWX(String toUserName, String fromUserName, Long createTime,
			String msgType) {
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
	}

	public MessageToWX(String toUserName, String fromUserName, String msgType) {
		this(toUserName, fromUserName, new Date().getTime(), msgType);
	}

	public MessageToWX(MessageFromWX msg, Long createTime, String msgType) {
		getMessageBaseInfo(msg);
		this.CreateTime = createTime;
		this.MsgType = msgType;
	}

	public MessageToWX(MessageFromWX msg, String msgType) {
		this(msg, new Date().getTime(), msgType);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return FromUserName + "," + ToUserName + "," + MsgType + ","
				+ CreateTime;
	}

	public void getMessageBaseInfo(MessageFromWX msg) {
		this.FromUserName = msg.getToUserName();
		this.ToUserName = msg.getFromUserName();
	}

}
