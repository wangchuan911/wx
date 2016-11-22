package my.hehe.controller;

import java.util.Date;

import javax.annotation.Resource;

import my.hehe.entity.message.receive.MessageBody4WX;
import my.hehe.entity.message.send.xml.TextMessage4WX;
import my.hehe.service.AuthService;
import my.hehe.service.MessageServiceImp;

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
	MessageServiceImp msgService;
	@Resource
	AuthService authService;

	// @RequestMapping(path = "/hehe/xml", produces = XML_TYPE)
	// public @ResponseBody
	// TextMessage4WX heheX() {
	//
	// return new TextMessage4WX("toUserName", "fromUserName",
	// new Date().getTime(), "msgType", "content", "msgId");
	// }
	//
	// @RequestMapping(path = "/hehe/json", produces = JSON_TYPE)
	// public @ResponseBody
	// Date heheJ() {
	// return new Date();
	// }

	@RequestMapping(path = "/wx", method = RequestMethod.GET)
	public String WX(@RequestParam String signature,
			@RequestParam String timestamp, @RequestParam String nonce,
			@RequestParam String echostr) throws AesException {
		return authService.wxToeknAuth(signature, timestamp, nonce, echostr);
	}

	@RequestMapping(path = "/wx", method = RequestMethod.POST, produces = XML_TYPE)
	// headers = "content-type=application/xml",
	public Object getMessage(
			@RequestBody(required = false) final MessageBody4WX message) {

		  return	msgService.receive(message);//

		
	}
	// @RequestMapping(path = "/receive2", method = RequestMethod.POST)
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
