package my.hehe.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import my.hehe.entity.HtmlInfo;
import my.hehe.entity.Token;
import my.hehe.entity.receive.MessageBody4WX;
import my.hehe.entity.send.TextMessage;
import my.hehe.service.parser.HtmlHandler;
import my.hehe.service.parser.HtmlPageParser;
import my.hehe.service.schedul.SyncTokenTask;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TextMessageServiceImp {
	@Resource
	private RestTemplate template;
	@Resource
	private Token token;

	@Value("${api.weixin.sendToUser}")
	private static String Send_URL;

	public void receiveText(MessageBody4WX message) {

		TextMessage msg = new TextMessage();

		List<HtmlInfo> infos;
		try {
			infos = HtmlPageParser.H2OParse(
					"http://www.tstdtz.com/tags/南宁停电通知", new HtmlHandler(),
					HtmlInfo.class);

			StringBuffer sb = new StringBuffer("[");
			for (int i = 0; i < (infos.size() > 5 ? 5 : infos.size()); i++) {
				sb.append(infos.get(i));
				if (i + 1 != infos.size()) {
					sb.append(",");
				}
			}
			sb.append("}");

			msg.setToUserName(message.getFromUserName());
			msg.setFromUserName(message.getToUserName());
			msg.setCreateTime(new Date().getTime());
			msg.setContent(sb.toString());

			Map<String, String> params = new HashMap<String, String>();
			params.put("token", token.getAccess_token());

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<TextMessage> entity = new HttpEntity<TextMessage>(msg,
					headers);

			template.postForObject(Send_URL, entity, TextMessage.class, params);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
