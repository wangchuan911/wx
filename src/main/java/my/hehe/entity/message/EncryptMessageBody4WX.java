package my.hehe.entity.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
class EncryptMessageBody4WX{
	private String ToUserName;
	private String Encrypt;
	public String getToUserName() {
		return ToUserName;
	}
	public String getEncrypt() {
		return Encrypt;
	}
	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}
	public void setEncrypt(String encrypt) {
		Encrypt = encrypt;
	}
}
