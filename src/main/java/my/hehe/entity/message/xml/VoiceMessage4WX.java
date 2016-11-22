package my.hehe.entity.message.xml;

import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.entity.message.Message4WX;

@XmlRootElement(name = "xml")
public class VoiceMessage4WX extends Message4WX{
private String MediaId;
private String Format;
private String Recognition;



public String getMediaId() {
	return MediaId;
}
public String getFormat() {
	return Format;
}
public void setMediaId(String mediaId) {
	MediaId = mediaId;
}
public void setFormat(String format) {
	Format = format;
}



}
