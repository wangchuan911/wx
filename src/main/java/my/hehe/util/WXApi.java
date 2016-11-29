package my.hehe.util;

import java.security.MessageDigest;
import java.util.Arrays;
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

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.SHA1;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

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

	@Value("${weixin.key}")
	private String key;

	private Token access_token;

	private static Map<String, String> map;

	private RestTemplate template;

	private WXBizMsgCrypt crypt;

	public String getAppID() {
		return appID;
	}

	public String getApptoken() {
		return apptoken;
	}

	public WXApi() {

	}

	public void setTemplate(RestTemplate template) {
		this.template = template;
	}

	public void intiCrypt() throws AesException {

		if (crypt == null) {
			synchronized (this) {
				if (crypt == null) {
					synchronized (this) {
						this.crypt = new WXBizMsgCrypt(apptoken, key, appID);
					}
				}
			}
		}
	}

	public void freshToken(int early) {
		if (map == null) {
			map = new HashMap<String, String>(4);
			map.put("appid", this.appID);
			map.put("secret", this.appsecret);
		}
		if (early != 0
				&& access_token != null
				&& (access_token.getExpires_date().getTimeInMillis()
						- (Calendar.getInstance().getTimeInMillis()) > (early * 1000 * 60))) {
			return;
		}
		this.access_token = template.getForObject(getToken_url, Token.class,
				map);
		map.put("token", access_token.getAccess_token());
		// System.out.println("token:"+token.getAccess_token());
	}

	public void freshToken() {
		freshToken(0);
	}

	public <T extends Message> void sendToUser(T t) {
		try {
			if (map.size() < 2) {
				freshToken();
			}
			map.put("token", access_token.getAccess_token());
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

	public String verifyUrl(String msgSignature, String timeStamp,
			String nonce, String echoStr) throws AesException {
		if (msgSignature.equals(SHA1.getSHA1(apptoken, timeStamp, nonce))) {
			return echoStr;
		} else {
			return null;
		}
	}

	public String decryptMsg(String msgSignature, String timeStamp,
			String nonce, String postData) throws AesException {
		intiCrypt();
		return crypt.decryptMsg(msgSignature, timeStamp, nonce, postData);
	}

	public String ecryptMsg(String replyMsg, String timeStamp, String nonce)
			throws AesException {
		intiCrypt();
		return crypt.encryptMsg(replyMsg, timeStamp, nonce);
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