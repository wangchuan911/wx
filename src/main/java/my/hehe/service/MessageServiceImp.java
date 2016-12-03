package my.hehe.service;

import my.hehe.service.processer.MessageProcesser;
import my.hehe.entity.message.MessageBody4WX;
import my.hehe.entity.message.MessageCreater;
import my.hehe.entity.message.from.ImageMessageFromWX;
import my.hehe.entity.message.from.LinkMessageFromWX;
import my.hehe.entity.message.from.LocationMessageFromWX;
import my.hehe.entity.message.from.ShortVideoMessageFromWX;
import my.hehe.entity.message.from.TextMessageFromWX;
import my.hehe.entity.message.from.VideoMessageFromWX;
import my.hehe.entity.message.from.VoiceMessageFromWX;
import my.hehe.entity.message.to.MessageToWX;
import my.hehe.util.WXType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImp {
	@Autowired
	private MessageProcesser processer;

	public MessageToWX receive(MessageBody4WX message) {

		try {
			if (message.getMsgType().equals(WXType.MSG_TYPE_TEXT)) {
				return processer.textProcess(MessageCreater.messageConverter(
						message, TextMessageFromWX.class));
//				return null;
			} else if (message.getMsgType().equals(WXType.MSG_TYPE_IMAGE)) {
				return processer.imageProcess(MessageCreater.messageConverter(
						message, ImageMessageFromWX.class));
			} else if (message.getMsgType().equals(WXType.MSG_TYPE_VIDEO)) {
				return processer.shortVideoProcess(MessageCreater
						.messageConverter(message,
								ShortVideoMessageFromWX.class));
			} else if (message.getMsgType().equals(WXType.MSG_TYPE_VIDEO)) {
				return processer.videoProcess(MessageCreater.messageConverter(
						message, VideoMessageFromWX.class));
			} else if (message.getMsgType().equals(WXType.MSG_TYPE_VOICE)) {
				return processer.voiceProcess(MessageCreater.messageConverter(
						message, VoiceMessageFromWX.class));
			} else if (message.getMsgType().equals(WXType.MSG_TYPE_LINK)) {
				return processer.linkProcess(MessageCreater.messageConverter(
						message, LinkMessageFromWX.class));
			} else if (message.getMsgType().equals(WXType.MSG_TYPE_LOCATION)) {
				return processer
						.locationProcess(MessageCreater.messageConverter(
								message, LocationMessageFromWX.class));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//	public <T> boolean inheritCheck(T object, Class<?>... clazz) {
//		boolean flag = false;
//		int i = 0;
//		while (!flag && i < clazz.length) {
//			flag = flag
//					|| object.getClass().getName().equals(clazz[i++].getName());
//		}
//		return flag;
//	}

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
