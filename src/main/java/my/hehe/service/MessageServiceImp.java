package my.hehe.service;

import java.util.Date;

import javax.annotation.Resource;

import my.hehe.entity.message.MessageBody4WX;
import my.hehe.entity.message.MessageCreater;
import my.hehe.entity.message.from.ImageMessageFromWX;
import my.hehe.entity.message.from.TextMessageFromWX;
import my.hehe.entity.message.to.ImageMessageToWX;
import my.hehe.entity.message.to.MessageToWX;
import my.hehe.entity.message.to.TextMessageToWX;
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

	public MessageToWX receive(MessageBody4WX message) {
		
		try {
			if (message.getMsgType().equals(WXType.TEXT)) {
				TextMessageFromWX from = MessageCreater.messageConverter(
						message, TextMessageFromWX.class);

				TextMessageToWX to = new TextMessageToWX(from);
				if (from.getContent().trim().equals("南宁")) {
					to.setContent(api.TD(message.getContent().trim(), 1, 0));
				} else {
					to.setContent("you say:" + message.getContent());
				}
				return to;
			} else if (message.getMsgType().equals(WXType.IMAGE)) {
				ImageMessageFromWX from = MessageCreater.messageConverter(
						message, ImageMessageFromWX.class);
				ImageMessageToWX to = new ImageMessageToWX(from);
				to.setMediaId(from.getMediaId());
				return to;
			} else if (message.getMsgType().equals(WXType.SHORT_VIDEO)) {

			} else if (message.getMsgType().equals(WXType.VIDEO)) {

			} else if (message.getMsgType().equals(WXType.VOICE)) {

			} else if (message.getMsgType().equals(WXType.LINK)) {

			} else if (message.getMsgType().equals(WXType.LOCATION)) {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return null;
	}

	public <T> boolean inheritCheck(T object, Class<?>... clazz) {
		boolean flag = false;
		int i = 0;
		while (!flag && i < clazz.length) {
			flag = flag
					|| object.getClass().getName().equals(clazz[i++].getName());
		}
		return flag;
	}

	// public static void main(String[] args) {
	// System.out.println(MessageServiceImp.ClassDefind(new ImageMessage4WX(),
	// MessageBody4WX.class,ImageMessage4WX.class));;
	// }
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
