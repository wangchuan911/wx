package my.hehe.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.SHA1;

@Service
public class AuthService {
	@Value(value = "${weixin.token}")
	private String token;

	public String wxToeknAuth(String signature, String timestamp, String nonce,
			String echostr) throws AesException {
		String sha1 = SHA1.getSHA1(token, timestamp, nonce);
		if (signature.equals(sha1)) {
			return echostr;
		} else
			return "";
	}
}
