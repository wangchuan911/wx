package my.hehe.service.schedul;

import my.hehe.entity.PropInfo;
import my.hehe.entity.Token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SyncTokenTask {
	@Autowired(required = true)
	public RestTemplate template;

	@Autowired(required = true)
	private Token token;

	@Autowired(required = true)
	private PropInfo prop;

	@Scheduled(initialDelay = 0, fixedDelay = 1000 * 60 * 90)
	// cron = "*/10 * * * * ?"
	// "1/5 * * * * ?"
	public void schedulSyncToken() {
		System.out.println(token);
		getNewToken();
	}

	public void getNewToken() {
		/*
		 * https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&
		 * appid=APPID&secret=APPSECRET
		 */
		StringBuffer sb = new StringBuffer(
				"https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=")
				.append(prop.getAppID()).append("&secret=")
				.append(prop.getAppsecret());
		System.out.println(template);
		Token token = template.getForEntity(sb.toString(), Token.class,
				new Object()).getBody();
		this.token.setAccess_token(token.getAccess_token());
		this.token.setExpires_in(token.getExpires_in());
		// 瀛楁 鍏佽鍊�鍏佽鐨勭壒娈婂瓧绗�
		// 绉�0-59 , - * /
		// 鍒�0-59 , - * /
		// 灏忔椂 0-23 , - * /
		// 鏃ユ湡 1-31 , - * ? / L W C
		// 鏈堜唤 1-12 鎴栬� JAN-DEC , - * /
		// 鏄熸湡 1-7 鎴栬� SUN-SAT , - * ? / L C #
		// 骞达紙鍙�锛�鐣欑┖, 1970-2099 , - * /
		// 琛ㄨ揪寮忔剰涔�
		// "0 0 12 * * ?" 姣忓ぉ涓崍12鐐硅Е鍙�
		// "0 15 10 ? * *" 姣忓ぉ涓婂崍10:15瑙﹀彂
		// "0 15 10 * * ?" 姣忓ぉ涓婂崍10:15瑙﹀彂
		// "0 15 10 * * ? *" 姣忓ぉ涓婂崍10:15瑙﹀彂
		// "0 15 10 * * ? 2005" 2005骞寸殑姣忓ぉ涓婂崍10:15瑙﹀彂
		// "0 * 14 * * ?" 鍦ㄦ瘡澶╀笅鍗�鐐瑰埌涓嬪崍2:59鏈熼棿鐨勬瘡1鍒嗛挓瑙﹀彂
		// "0 0/5 14 * * ?" 鍦ㄦ瘡澶╀笅鍗�鐐瑰埌涓嬪崍2:55鏈熼棿鐨勬瘡5鍒嗛挓瑙﹀彂
		// "0 0/5 14,18 * * ?" 鍦ㄦ瘡澶╀笅鍗�鐐瑰埌2:55鏈熼棿鍜屼笅鍗�鐐瑰埌6:55鏈熼棿鐨勬瘡5鍒嗛挓瑙﹀彂
		// "0 0-5 14 * * ?" 鍦ㄦ瘡澶╀笅鍗�鐐瑰埌涓嬪崍2:05鏈熼棿鐨勬瘡1鍒嗛挓瑙﹀彂
		// "0 10,44 14 ? 3 WED" 姣忓勾涓夋湀鐨勬槦鏈熶笁鐨勪笅鍗�:10鍜�:44瑙﹀彂
		// "0 15 10 ? * MON-FRI" 鍛ㄤ竴鑷冲懆浜旂殑涓婂崍10:15瑙﹀彂
		// "0 15 10 15 * ?" 姣忔湀15鏃ヤ笂鍗�0:15瑙﹀彂
		// "0 15 10 L * ?" 姣忔湀鏈�悗涓�棩鐨勪笂鍗�0:15瑙﹀彂
		// "0 15 10 ? * 6L" 姣忔湀鐨勬渶鍚庝竴涓槦鏈熶簲涓婂崍10:15瑙﹀彂
		// "0 15 10 ? * 6L 2002-2005" 2002骞磋嚦2005骞寸殑姣忔湀鐨勬渶鍚庝竴涓槦鏈熶簲涓婂崍10:15瑙﹀彂
		// "0 15 10 ? * 6#3" 姣忔湀鐨勭涓変釜鏄熸湡浜斾笂鍗�0:15瑙﹀彂
		// 姣忓ぉ鏃╀笂6鐐�
		// 0 6 * * *
		// 姣忎袱涓皬鏃�
		// 0 */2 * * *
		// 鏅氫笂11鐐瑰埌鏃╀笂8鐐逛箣闂存瘡涓や釜灏忔椂锛屾棭涓婂叓鐐�
		// 0 23-7/2锛� * * *
		// 姣忎釜鏈堢殑4鍙峰拰姣忎釜绀兼嫓鐨勭ぜ鎷滀竴鍒扮ぜ鎷滀笁鐨勬棭涓�1鐐�
		// 0 11 4 * 1-3
		// 1鏈�鏃ユ棭涓�鐐�
		// 0 4 1 1 *

	}

}
