package my.hehe.util;

import java.util.HashMap;
import java.util.Map;

import my.hehe.entity.Token;
import my.hehe.entity.receive.MessageBody4WX;
import my.hehe.entity.send.Message;
import my.hehe.entity.send.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WXApi {
	@Value("${weixin.appID}")
	private String appID;

	@Value("${weixin.appsecret}")
	private String appsecret;

	@Value("${weixin.token}")
	private String apptoken;

	@Value("${getToken}")
	private String getToken_url;

	@Value("${sendToUser}")
	private String sendToUser_url;

	private static Token token;

	// public String getAppID() {
	// return appID;
	// }
	//
	// public String getAppsecret() {
	// return appsecret;
	// }
	//
	// public String getApptoken() {
	// return apptoken;
	// }
	//
	// public void setAppID(String appID) {
	// this.appID = appID;
	// }
	//
	// public void setAppsecret(String appsecret) {
	// this.appsecret = appsecret;
	// }
	//
	// public void setApptoken(String apptoken) {
	// this.apptoken = apptoken;
	// }

	private RestTemplate template;

	public WXApi(RestTemplate template) {
		this.template = template;
	}

	public Token getToken() {
		Map<String, String> map = null;
		try {
			map = new HashMap<String, String>();
			map.put("appid", this.appID);
			map.put("secret", this.appsecret);
			token = template.getForObject(getToken_url, Token.class, map);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (map != null) {
				map.clear();
			}
		}
		return token;
	}

	public <T extends Message> void sendToUser(MessageBody4WX message, T t) {
		Map<String, String> map = null;
		try {
			map = new HashMap<String, String>();
			map.put("token", token.getAccess_token());

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<T> entity = new HttpEntity<T>(t, headers);
			template.postForObject(sendToUser_url, entity, TextMessage.class,
					map);

			template.getForObject(sendToUser_url, Token.class, map);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (map != null) {
				map.clear();
			}
		}
	}
}
