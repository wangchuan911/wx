package my.hehe.entity.send.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class Message {

	protected String touser;
	
	protected String msgtype;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public Message(String touser, String msgtype) {
		super();
		this.touser = touser;
		this.msgtype = msgtype;
	}

	public Message() {
		super();
	}
	
	
}
