package my.hehe.service;

import javax.annotation.Resource;

import my.hehe.util.WXApi;

import org.springframework.stereotype.Service;

import com.qq.weixin.mp.aes.AesException;

@Service
public class AuthService {
	@Resource
	private WXApi api;

	public String wxToeknAuth(String signature, String timestamp, String nonce,
			String echostr) throws AesException {
		return api.verifyUrl(signature, timestamp, nonce, echostr);
	}
}
