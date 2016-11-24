package my.hehe.util;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import my.hehe.entity.Token;
import my.hehe.entity.message.to.customer.Message;
import my.hehe.entity.message.to.customer.TextMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class WXApi {
	@Value("${weixin.appID}")
	private String appID;

	@Value("${weixin.appsecret}")
	private String appsecret;

	@Value("${weixin.token}")
	private String apptoken;

	@Value("${weixin.getToken}")
	private String getToken_url;

	@Value("${weixin.sendToUser}")
	private String sendToUser_url;

	@Value("${weixin.getIPs}")
	private String getIPs_url;

	private Token token;

	private static Map<String, String> map;

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

	public WXApi() {
	}

	public void setTemplate(RestTemplate template) {
		this.template = template;
	}
	

	public void freshToken(int early) {
		if (map == null) {
			map = new HashMap<String, String>(4);
			map.put("appid", this.appID);
			map.put("secret", this.appsecret);
		}
		if (early != 0
				&& token != null
				&& (token.getExpires_date().getTimeInMillis()
						- (Calendar.getInstance().getTimeInMillis()) > (early * 1000 * 60))) {
			return;
		}
		this.token = template.getForObject(getToken_url, Token.class, map);
		map.put("token", token.getAccess_token());
//		System.out.println("token:"+token.getAccess_token());
	}

	public void freshToken() {
		freshToken(0);
	}

	public <T extends Message> void sendToUser(T t) {
		try {			
			if(map.size()<2){
				freshToken();
			}
			map.put("token", token.getAccess_token());
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<T> entity = new HttpEntity<T>(t, headers);
			template.postForObject(sendToUser_url, entity, TextMessage.class,
					map);

			template.getForObject(sendToUser_url, Token.class, map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (map != null) {
				map.clear();
			}
		}
	}

	public String[] getIPs() {

		if (map == null || map.get("token") == null) {
			this.freshToken();
		}
		IPs ips = template.getForObject(getIPs_url, IPs.class, map);

		String[] ips_str = new String[ips.getIp_list().size()];
		for (int i = 0; i < ips_str.length; i++) {
			String ip = ips.getIp_list().get(i);
			int offset = ip.indexOf('/');
			if (offset != -1) {
				ip = ip.substring(0, offset);
			}
			ips_str[i] = ip;
		}
		return ips_str;

	}
}

class IPs {
	private List<String> ip_list;

	public List<String> getIp_list() {
		return ip_list;
	}

	public void setIp_list(List<String> ip_list) {
		this.ip_list = ip_list;
	}
}