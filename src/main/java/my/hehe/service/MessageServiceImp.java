package my.hehe.service;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.Resource;

import my.hehe.entity.HtmlInfo;
import my.hehe.entity.receive.MessageBody4WX;
import my.hehe.entity.send.json.TextMessage;
import my.hehe.entity.send.json.TextMessage.Text;
import my.hehe.entity.send.xml.Message4WX;
import my.hehe.entity.send.xml.TextMessage4WX;
import my.hehe.service.parser.HtmlHandler;
import my.hehe.service.parser.HtmlPageParser;
import my.hehe.util.TSTDTZApi;
import my.hehe.util.WXApi;
import my.hehe.util.WXType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImp {
	// @Resource
	// private RestTemplate template;
	// @Resource
	// private Token token;

	// @Value("${api.weixin.sendToUser}")
	// private static String Send_URL;

	@Resource
	private TSTDTZApi api;

	public Object receive(MessageBody4WX message) {

		try {
			if (message.getMsgType().equals(WXType.TEXT)) {
				TextMessage4WX text = new TextMessage4WX();
				text.setCreateTime(new Date().getTime());
				text.setFromUserName(message.getToUserName());
				text.setToUserName(message.getFromUserName());
				text.setMsgId(message.getMediaId());
				if (message.getContent().trim().equals("南宁")) {
					text.setContent(api.TD(message.getContent().trim(), 1, 0));
				} else {
					text.setContent("you say:" + message.getContent());
				}
				return text;
			}
			if (message.getMsgType().equals(WXType.IMAGE)) {

			}
			if (message.getMsgType().equals(WXType.SHORT_VIDEO)) {

			}
			if (message.getMsgType().equals(WXType.VOICE)) {

			}

			// msg.setToUserName(message.getFromUserName());

			// TextMessage msg = new TextMessage(message.getFromUserName(),
			// message.getMsgType(), new
			// Text("the user:"+message.getFromUserName()+" say :"+message.getContent()));//
			// "oHVYhxLCD5jluKrhBQZsaVubtdVU"
			// api.sendToUser(msg);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}

	public static void main(String[] args) {
		MessageCreater.messageConverter(new MessageBody4WX(), TextMessage4WX.class);
	}
}

class MessageCreater {
	public static <T extends Message4WX> T messageConverter(MessageBody4WX body, Class<T> clazz) {
		try {
			Field[] clazz_field = clazz.getDeclaredFields();
			for (Field field : clazz_field) {
				field.setAccessible(true);
				System.out.println(field.getName());
			}
			
			Class clazz_super=clazz.getSuperclass();
			Field[] clazz_super_field =clazz_super.getDeclaredFields();
			for (Field field : clazz_super_field) {
				field.setAccessible(true);
				System.out.println(field.getName());
			}
			Set<String> set=new HashSet<String>();
			set.toArray();
			
	
			Method[] m = clazz.getMethods();
			if (body == null) {
				return null;
			}
			Class body_clazz = body.getClass();
			Field[] body_fields = body_clazz.getFields();
			System.out.println(body_fields.length);
			Method[] body_methods = body_clazz.getMethods();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}
}
