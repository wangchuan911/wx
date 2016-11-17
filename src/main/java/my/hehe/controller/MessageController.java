package my.hehe.controller;

import java.util.Date;

import javax.annotation.Resource;

import my.hehe.entity.receive.MessageBody4WX;
import my.hehe.entity.receive.TextMessage4WX;
import my.hehe.service.AuthService;
import my.hehe.service.TextMessageServiceImp;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qq.weixin.mp.aes.AesException;

@RestController
public class MessageController {
	static final String XML_TYPE = "application/xml; charset=UTF-8";
	static final String JSON_TYPE = "application/json; charset=UTF-8";

	@Resource
	TextMessageServiceImp textMessageService;
	@Resource
	AuthService authService;

	@RequestMapping(path = "/hehe/xml", produces = XML_TYPE)
	public @ResponseBody
	TextMessage4WX heheX() {

		return new TextMessage4WX("toUserName", "fromUserName",
				new Date().getTime(), "msgType", "content", "msgId");
	}

	@RequestMapping(path = "/hehe/json", produces = JSON_TYPE)
	public @ResponseBody
	Date heheJ() {
		return new Date();
	}

	@RequestMapping(path = "/wx", method = RequestMethod.GET)
	public String WX(@RequestParam String signature,
			@RequestParam String timestamp, @RequestParam String nonce,
			@RequestParam String echostr) throws AesException {
		return authService.wxToeknAuth(signature, timestamp, nonce, echostr);
	}
	@CrossOrigin(origins = "http://localhost")
	@RequestMapping(path = "/receive", headers = "content-type=application/xml", method = RequestMethod.POST)
	public Object getTextMessage(
			@RequestBody(required = false) MessageBody4WX message) {
		System.out.println(message);
		try {
			// new Thread(new Runnable() {
			//
			// public void run() {
			// // TODO Auto-generated method stub
			// System.out.println(message);
			// textMessageService.receiveText(message);//
			// }
			// }).start();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
		}
		return "success";
	}

}
