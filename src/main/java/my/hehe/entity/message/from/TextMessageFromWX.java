package my.hehe.entity.message.from;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.util.WXType;

@XmlRootElement(name = "xml")
public class TextMessageFromWX extends MessageFromWX{

	private String Content;
	
	
	@XmlElement(name="Content")
	public String getContent() {
		return this.Content;
	}

	public void setContent(String content) {
		this.Content = content;
	}


	public TextMessageFromWX() {
		this.setMsgType(WXType.TEXT);
	}
	

	public TextMessageFromWX(String toUserName, String fromUserName,
			Long createTime,  String content, String msgId) {
		super();
		this.setToUserName(toUserName); 
		this.setFromUserName(fromUserName);
		this.setCreateTime(createTime);
		this.setMsgType("text");
		this.Content = content;
		this.setMsgId(msgId);

	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TextMessage4WX [Content=");
		builder.append(Content);
		builder.append(", ToUserName=");
		builder.append(ToUserName);
		builder.append(", FromUserName=");
		builder.append(FromUserName);
		builder.append(", CreateTime=");
		builder.append(CreateTime);
		builder.append(", MsgType=");
		builder.append(MsgType);
		builder.append(", MsgId=");
		builder.append(MsgId);
		builder.append("]");
		return builder.toString();
	}

}
