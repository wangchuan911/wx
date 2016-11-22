package my.hehe.entity.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "xml")
public abstract class Message4WX {

	protected String ToUserName;
	
	protected String FromUserName;
	
	protected Long CreateTime;
	
	protected String MsgType;
	
	protected String MsgId;
	

	@XmlElement(name="ToUserName")
	public String getToUserName() {
		return ToUserName;
	}
	@XmlElement(name="FromUserName")
	public String getFromUserName() {
		return FromUserName;
	}
	@XmlElement(name="CreateTime")
	public Long getCreateTime() {
		return CreateTime;
	}
	@XmlElement(name="MsgType")
	public String getMsgType() {
		return MsgType;
	}
	@XmlElement(name="MsgId")
	public String getMsgId() {
		return MsgId;
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

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

	public Message4WX(){
	}
	
	public Message4WX(String toUserName, String fromUserName, Long createTime,
			String msgType, String msgId) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;
		MsgId = msgId;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return MsgId+","+FromUserName+","+ToUserName+","+MsgType+","+CreateTime;
	}
	public void fromToSwap() {
		String temp = this.ToUserName;
		this.ToUserName = this.FromUserName;
		this.FromUserName = temp;
	}
}
