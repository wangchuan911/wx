package my.hehe.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.entity.message.MessageBody4WX;
import my.hehe.service.AuthService;
import my.hehe.service.MessageServiceImp;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qq.weixin.mp.aes.AesException;

@RestController
public class MessageController {
	static final String XML_TYPE = "application/xml; charset=UTF-8";
	static final String JSON_TYPE = "application/json; charset=UTF-8";

	@Resource
	MessageServiceImp msgService;
	@Resource
	AuthService authService;

	@RequestMapping(path = "/wx", method = RequestMethod.GET)
	public String WX(@RequestParam String signature,
			@RequestParam String timestamp, @RequestParam String nonce,
			@RequestParam String echostr) throws AesException {
		return authService.wxToeknAuth(signature, timestamp, nonce, echostr);
	}

	@RequestMapping(path = "/wx", method = RequestMethod.POST, produces = XML_TYPE)
	// headers = "content-type=application/xml"
	public Object getMessage(
			@RequestBody(required = false) final MessageBody4WX message) {
//		System.out.println(message);
		Object object = msgService.receive(message);
		return (object != null) ? object : "success";//
	}
	// @RequestMapping(path = "/wx", method = RequestMethod.POST)
	// public Object getMessage2(
	// HttpServletRequest request) throws UnsupportedEncodingException,
	// IOException {
	// // System.out.println(message);
	// BufferedReader br=new BufferedReader(new
	// InputStreamReader(request.getInputStream(),"utf-8"));
	// String str;
	// do {
	// str=br.readLine();
	// System.out.println(str);
	// }
	// return "success";
	// }

}
//
//class RequestParamer {
//	private String signature;
//	private String timestamp;
//	private String nonce;
//
//	public String getSignature() {
//		return signature;
//	}
//
//	public String getTimestamp() {
//		return timestamp;
//	}
//
//	public String getNonce() {
//		return nonce;
//	}
//
//	public void setSignature(String signature) {
//		this.signature = signature;
//	}
//
//	public void setTimestamp(String timestamp) {
//		this.timestamp = timestamp;
//	}
//
//	public void setNonce(String nonce) {
//		this.nonce = nonce;
//	}
//
//}
