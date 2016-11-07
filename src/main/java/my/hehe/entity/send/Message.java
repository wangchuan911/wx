package my.hehe.entity.send;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class Message {

	protected String ToUserName;
	
	protected String FromUserName;
	
	protected Long CreateTime;
	
	protected String MsgType;
	

	
	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}
	
	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	
	public Message(){}
	
	public Message(String toUserName, String fromUserName, Long createTime,
			String msgType, String msgId) {
		super();
		ToUserName = toUserName;
		FromUserName = fromUserName;
		CreateTime = createTime;
		MsgType = msgType;

	}

}
