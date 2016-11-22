package my.hehe.entity.message.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.entity.message.Message4WX;
import my.hehe.util.WXType;

@XmlRootElement(name = "xml")
public class LocationMessage4WX extends Message4WX{
private String	Location_X;
private String	Location_Y;
private String	Scale;
private String	Label;
public String getLocation_X() {
	return Location_X;
}
public String getLocation_Y() {
	return Location_Y;
}
public String getScale() {
	return Scale;
}
public String getLabel() {
	return Label;
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
	



}
