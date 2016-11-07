package my.hehe.entity.receive;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class TextMessage4WX extends Message4WX{

	private String Content;
	
	
	@XmlElement(name="Content")
	public String getContent() {
		return this.Content;
	}

	public void setContent(String content) {
		this.Content = content;
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

	public TextMessage4WX() {
	}

	public TextMessage4WX(String toUserName, String fromUserName,
			Long createTime, String msgType, String content, String msgId) {
		super();
		this.setToUserName(toUserName); 
		this.setFromUserName(fromUserName);
		this.setCreateTime(createTime);
		this.setMsgType(msgType);
		this.Content = content;
		this.setMsgId(msgId);
	}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString()+","+Content;
}
}
