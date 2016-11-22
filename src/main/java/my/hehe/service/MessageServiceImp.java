package my.hehe.service;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import my.hehe.entity.message.Message4WX;
import my.hehe.entity.message.MessageBody4WX;
import my.hehe.entity.message.MessageCreater;
import my.hehe.entity.message.xml.ImageMessage4WX;
import my.hehe.entity.message.xml.TextMessage4WX;
import my.hehe.util.TSTDTZApi;
import my.hehe.util.WXType;

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
				TextMessage4WX text = MessageCreater.messageConverter(message,
						TextMessage4WX.class);
				// TextMessage4WX text = new TextMessage4WX();
				// text.setCreateTime(new Date().getTime());
				// text.setFromUserName(message.getToUserName());
				// text.setToUserName(message.getFromUserName());
				// text.setMsgId(message.getMediaId());
				// if (message.getContent().trim().equals("南宁")) {
				// text.setContent(api.TD(message.getContent().trim(), 1, 0));
				// } else {
				// text.setContent("you say:" + message.getContent());
				// }
				if (text.getContent().trim().equals("南宁")) {
					text.setContent(api.TD(message.getContent().trim(), 1, 0));
				} else {
					text.setContent("you say:" + message.getContent());
				}
				text.fromToSwap();
				return text;
			} else if (message.getMsgType().equals(WXType.IMAGE)) {
				ImageMessage4WX image = MessageCreater.messageConverter(
						message, ImageMessage4WX.class);
				System.out.println(image);
				image.fromToSwap();
				return image;
			} else if (message.getMsgType().equals(WXType.SHORT_VIDEO)) {

			} else if (message.getMsgType().equals(WXType.VOICE)) {

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

	// public static void main(String[] args) {
	// MessageBody4WX t = new MessageBody4WX();
	// t.setContent("a");
	// t.setFromUserName("b");
	// t.setToUserName("c");
	// t.setMsgId("aa");
	// t.setMsgType("text");
	// t.setCreateTime(11111L);
	//
	// // System.out.println(MessageCreater.messageConverter2(t,
	// // TextMessage4WX.class));
	//
	//
	// ImageMessage4WX tt=MessageCreater.messageConverter(t,
	// ImageMessage4WX.class);
	// System.out.println(tt);
	// tt.fromToSwap();
	// System.out.println(tt);
	// }
}
