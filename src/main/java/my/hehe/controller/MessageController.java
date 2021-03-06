package my.hehe.controller;

import javax.annotation.Resource;
import my.hehe.entity.message.MessageBody4WX;
import my.hehe.service.AuthService;
import my.hehe.service.MessageServiceImp;

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

		Object object = msgService.receive(message);
		return (object != null) ? object : "success";//
	}
}
