package my.hehe.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

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

	public Object receiveText(MessageBody4WX message) {

		try {
			if (message.getMsgType().equals("text")) {
				TextMessage4WX text = new TextMessage4WX();
				text.setCreateTime(new Date().getTime());
				text.setFromUserName(message.getToUserName());
				text.setToUserName(message.getFromUserName());
				text.setMsgId(message.getMediaId());
				if (message.getContent().trim().equals("南宁")) {
					text.setContent(api.TD(message.getContent().trim(), 1,0));
				} else {
					text.setContent("you say:" + message.getContent());
				}

				return text;
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
}
