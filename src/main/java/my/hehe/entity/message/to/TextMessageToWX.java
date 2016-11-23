package my.hehe.entity.message.to;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.entity.message.from.MessageFromWX;
import my.hehe.util.WXType;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextMessageToWX extends MessageToWX {
	@XmlElement(name = "Content")
	private String Content;

	
	public String getContent() {
		return this.Content;
	}

	public void setContent(String content) {
		this.Content = content;
	}

	public TextMessageToWX() {
		this.setMsgType(WXType.TEXT);
	}

	public TextMessageToWX(String toUserName, String fromUserName,
			Long createTime) {
		super(toUserName, fromUserName, createTime, WXType.TEXT);
	}

	public TextMessageToWX(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, WXType.TEXT);
	}

	public TextMessageToWX(MessageFromWX msg, Long createTime) {
		super(msg, createTime, WXType.TEXT);
	}

	public TextMessageToWX(MessageFromWX msg) {
		super(msg, WXType.TEXT);
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
		builder.append("]");
		return builder.toString();
	}

}
