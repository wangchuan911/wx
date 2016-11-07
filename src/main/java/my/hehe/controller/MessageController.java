package my.hehe.controller;

import java.util.Date;

import javax.annotation.Resource;

import my.hehe.entity.receive.MessageBody4WX;
import my.hehe.entity.receive.TextMessage4WX;
import my.hehe.service.TextMessageServiceImp;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	@Resource
	TextMessageServiceImp service;

	@RequestMapping(path = "/hehe/xml", produces = "application/xml; charset=UTF-8")
	public @ResponseBody
	TextMessage4WX heheX() {

		return new TextMessage4WX("toUserName", "fromUserName",
				new Date().getTime(), "msgType", "content", "msgId");
	}

	@RequestMapping(path = "/hehe/json")
	public @ResponseBody
	Date heheJ() {
		return new Date();
	}

	@RequestMapping(path = "/wx",method=RequestMethod.GET)
	public String WX(@RequestParam String signature,
			@RequestParam String timestamp, @RequestParam String nonce,
			@RequestParam String echostr) {
		System.out.println(signature);
		
		return null;
	}

	@RequestMapping(path = "/receive", headers = "content-type=application/xml")
	public Object getTextMessage(
			@RequestBody(required = false) final MessageBody4WX message) {
		try {
			new Thread(new Runnable() {

				public void run() {
					// TODO Auto-generated method stub
					System.out.println(message);
					service.receiveText(message);//
				}
			}).start();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
		}
		return "success";
	}

}
