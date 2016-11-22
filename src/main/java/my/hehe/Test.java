package my.hehe;

import java.util.Date;

import my.hehe.entity.message.Message4WX;
import my.hehe.entity.message.MessageBody4WX;
import my.hehe.entity.message.xml.ImageMessage4WX;
import my.hehe.entity.message.xml.TextMessage4WX;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Test {
	public static void main(String[] args) {
		demo3();

	}

//	public static void demo() {
//		try {
//			String uri = "http://localhost:8080/receive";
//			RestTemplate template = new RestTemplate();
//			HttpHeaders headers = new HttpHeaders();
//			headers.setContentType(MediaType.APPLICATION_XML);
////			HttpEntity<TextMessage4WX> entity = new HttpEntity<TextMessage4WX>(
////					new TextMessage4WX("hehe", "haha", new Date().getTime(),
////							"text", "aaa", "1"), headers);
////			HttpEntity<Message4WX> entity = new HttpEntity<Message4WX>(
////					new Message4WX("hehe", "haha", new Date().getTime(),
////							,  "1"), headers);
//			
//			System.out.println(template
//					.postForObject(uri, entity, String.class));
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
	public static void demo2() {
		try {
			String uri = "http://localhost/receive2";//139.199.164.14
//			uri = "http://139.199.164.14/receive";
			RestTemplate template = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_XML);
			System.out.println(headers);
			HttpEntity<TextMessage4WX> entity = new HttpEntity<TextMessage4WX>(
					new TextMessage4WX("hehe", "haha", new Date().getTime(),
							 "aaa", "1"), headers);

			System.out.println(template
					.postForObject(uri, entity, String.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void demo3() {
		try {
			String uri = "http://139.199.164.14/wx";//139.199.164.14
//			uri = "http://139.199.164.14/receive";
			RestTemplate template = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_XML);
			System.out.println(headers);
			MessageBody4WX m=new MessageBody4WX();
			m.setFromUserName("a");
			m.setMsgType("image");
			m.setToUserName("c");
			m.setPicUrl("aaaa");
			HttpEntity<MessageBody4WX> entity = new HttpEntity<MessageBody4WX>(
					m, headers);

			System.out.println(template
					.postForObject(uri, entity, String.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
