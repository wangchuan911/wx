package my.hehe.entity.send.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class Message4WX2XML extends Message4WX{


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

	@Override
	public void setMsgType(String msgType) {
		// TODO Auto-generated method stub
		super.setMsgType(msgType);
	}
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

	public Message4WX2XML() {
	}

	public Message4WX2XML(String toUserName, String fromUserName,
			Long createTime, String msgType,  String msgId) {
		super();
		this.setToUserName(toUserName); 
		this.setFromUserName(fromUserName);
		this.setCreateTime(createTime);
		this.setMsgType(msgType);
		this.setMsgId(msgId);
	}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}
}
