package my.hehe.entity.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class MessageBody4WX {

	private String URL;

	@XmlElement(name = "URL")
	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	private String ToUserName;

	private String FromUserName;

	private Long CreateTime;

	private String MsgType;

	private String MsgId;

	private String MediaId;

	private String PicUrl;

	private String Format;

	private String ThumbMediaId;

	private String Location_X;

	private String Location_Y;

	private String Scale;

	private String Label;

	private String Title;

	private String Description;

	private String Url;

	private String Content;
	
	private String Recognition;
	
	private String Encrypt;

	@XmlElement(name = "ToUserName")
	public String getToUserName() {
		return ToUserName;
	}

	@XmlElement(name = "FromUserName")
	public String getFromUserName() {
		return FromUserName;
	}

	@XmlElement(name = "CreateTime")
	public Long getCreateTime() {
		return CreateTime;
	}

	@XmlElement(name = "MsgType")
	public String getMsgType() {
		return MsgType;
	}

	@XmlElement(name = "MsgId")
	public String getMsgId() {
		return MsgId;
	}

	@XmlElement(name = "MediaId")
	public String getMediaId() {
		return MediaId;
	}

	@XmlElement(name = "PicUrl")
	public String getPicUrl() {
		return PicUrl;
	}

	@XmlElement(name = "Format")
	public String getFormat() {
		return Format;
	}

	@XmlElement(name = "ThumbMediaId")
	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	@XmlElement(name = "Location_X")
	public String getLocation_X() {
		return Location_X;
	}

	@XmlElement(name = "Location_Y")
	public String getLocation_Y() {
		return Location_Y;
	}

	@XmlElement(name = "Scale")
	public String getScale() {
		return Scale;
	}

	@XmlElement(name = "Label")
	public String getLabel() {
		return Label;
	}

	@XmlElement(name = "Title")
	public String getTitle() {
		return Title;
	}

	@XmlElement(name = "Description")
	public String getDescription() {
		return Description;
	}

	@XmlElement(name = "Url")
	public String getUrl() {
		return Url;
	}

	@XmlElement(name = "Content")
	public String getContent() {
		return Content;
	}

	@XmlElement(name = "Recognition")
	public String getRecognition() {
		return Recognition;
	}

	
	@XmlElement(name = "Encrypt")
	public String getEncrypt() {
		return Encrypt;
	}

	public void setEncrypt(String encrypt) {
		Encrypt = encrypt;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
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

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public void setContent(String content) {
		Content = content;
	}

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageBody4WX [URL=");
		builder.append(URL);
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
		builder.append(", MediaId=");
		builder.append(MediaId);
		builder.append(", PicUrl=");
		builder.append(PicUrl);
		builder.append(", Format=");
		builder.append(Format);
		builder.append(", ThumbMediaId=");
		builder.append(ThumbMediaId);
		builder.append(", Location_X=");
		builder.append(Location_X);
		builder.append(", Location_Y=");
		builder.append(Location_Y);
		builder.append(", Scale=");
		builder.append(Scale);
		builder.append(", Label=");
		builder.append(Label);
		builder.append(", Title=");
		builder.append(Title);
		builder.append(", Description=");
		builder.append(Description);
		builder.append(", Url=");
		builder.append(Url);
		builder.append(", Content=");
		builder.append(Content);
		builder.append("]");
		return builder.toString();
	}

	public MessageBody4WX decrypt(){
		if(	this.Encrypt==null){
			return this;
		}else {
		}
		return null;
	}


}
