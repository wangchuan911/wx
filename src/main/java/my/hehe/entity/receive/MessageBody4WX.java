package my.hehe.entity.receive;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class MessageBody4WX {

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

	
	@XmlElement(name="ToUserName")
	public String getToUserName() {
		return ToUserName;
	}


	@XmlElement(name="FromUserName")
	public String getFromUserName() {
		return FromUserName;
	}


	@XmlElement(name="CreateTime")
	public Long getCreateTime() {
		return CreateTime;
	}


	@XmlElement(name="MsgType")
	public String getMsgType() {
		return MsgType;
	}


	@XmlElement(name="MsgId")
	public String getMsgId() {
		return MsgId;
	}


	@XmlElement(name="MediaId")
	public String getMediaId() {
		return MediaId;
	}


	@XmlElement(name="PicUrl")
	public String getPicUrl() {
		return PicUrl;
	}


	@XmlElement(name="Format")
	public String getFormat() {
		return Format;
	}


	@XmlElement(name="ThumbMediaId")
	public String getThumbMediaId() {
		return ThumbMediaId;
	}


	@XmlElement(name="Location_X")
	public String getLocation_X() {
		return Location_X;
	}


	@XmlElement(name="Location_Y")
	public String getLocation_Y() {
		return Location_Y;
	}


	@XmlElement(name="Scale")
	public String getScale() {
		return Scale;
	}


	@XmlElement(name="Label")
	public String getLabel() {
		return Label;
	}


	@XmlElement(name="Title")
	public String getTitle() {
		return Title;
	}


	@XmlElement(name="Description")
	public String getDescription() {
		return Description;
	}


	@XmlElement(name="Url")
	public String getUrl() {
		return Url;
	}


	@XmlElement(name="Content")
	public String getContent() {
		return Content;
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
		return "MessageBody4WX [ToUserName=" + ToUserName + ", FromUserName="
				+ FromUserName + ", CreateTime=" + CreateTime + ", MsgType="
				+ MsgType + ", MsgId=" + MsgId + ", MediaId=" + MediaId
				+ ", PicUrl=" + PicUrl + ", Format=" + Format
				+ ", ThumbMediaId=" + ThumbMediaId + ", Location_X="
				+ Location_X + ", Location_Y=" + Location_Y + ", Scale="
				+ Scale + ", Label=" + Label + ", Title=" + Title
				+ ", Description=" + Description + ", Url=" + Url
				+ ", Content=" + Content + "]";
	}





}
