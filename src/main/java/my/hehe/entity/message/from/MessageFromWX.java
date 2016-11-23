package my.hehe.entity.message.from;

public abstract class MessageFromWX {

	protected String ToUserName;
	
	protected String FromUserName;
	
	protected Long CreateTime;
	
	protected String MsgType;
	
	protected String MsgId;
	


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

	public MessageFromWX(){
	}
	
	public MessageFromWX(String toUserName, String fromUserName, Long createTime,
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
