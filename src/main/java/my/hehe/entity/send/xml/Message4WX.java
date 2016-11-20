package my.hehe.entity.send.xml;

public abstract class Message4WX {

	private String ToUserName;
	
	private String FromUserName;
	
	private Long CreateTime;
	
	private String MsgType;
	
	private String MsgId;
	
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
	
	protected void setMsgType(String msgType) {
		MsgType = msgType;
	}


	public String getMsgId() {
		return MsgId;
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

}
