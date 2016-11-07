package my.hehe.entity.send;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class TextMessage extends Message {

	
	
	protected String Content;
	
	@XmlElement(name="ToUserName")
	public String getToUserName() {
		return this.ToUserName;
	}

	public void setToUserName(String toUserName) {
		this.ToUserName = toUserName;
	}
	@XmlElement(name="FromUserName")
	public String getFromUserName() {
		return this.FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		this.FromUserName = fromUserName;
	}
	@XmlElement(name="CreateTime")
	public Long getCreateTime() {
		return this.CreateTime;
	}

	public void setCreateTime(Long createTime) {
		this.CreateTime = createTime;
	}
	@XmlElement(name="MsgType")
	public String getMsgType() {
		return this.MsgType;
	}
	
	public void setMsgType(String msgType) {
		this.MsgType = msgType;
	}
	@XmlElement(name="Content")
	public String getContent() {
		return this.Content;
	}

	public void setContent(String content) {
		this.Content = content;
	}
	
	public TextMessage(){}
	
	public TextMessage(String toUserName, String fromUserName, Long createTime,
			String msgType, String content) {
		super();
		this.ToUserName = toUserName;
		this.FromUserName = fromUserName;
		this.CreateTime = createTime;
		this.MsgType = msgType;
		this.Content = content;
	}

}
