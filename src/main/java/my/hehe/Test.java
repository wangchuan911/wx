package my.hehe;

import java.util.Date;

import my.hehe.entity.message.MessageBody4WX;
import my.hehe.entity.message.from.TextMessageFromWX;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Test {
	public static void main(String[] args) {
		demo2();
//		demo3();
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
			String uri = "http://localhost/wx";//139.199.164.14
//			uri = "http://139.199.164.14/receive";
			RestTemplate template = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_XML);
			System.out.println(headers);
			HttpEntity<TextMessageFromWX> entity = new HttpEntity<TextMessageFromWX>(
					new TextMessageFromWX("hehe", "haha", new Date().getTime(),
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
			uri = "http://localhost/wx";
			RestTemplate template = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_XML);
			System.out.println(headers);
			MessageBody4WX m=new MessageBody4WX();
			m.setFromUserName("a");
			m.setMsgType("image");
			m.setToUserName("c");
			m.setPicUrl("aaaa");
			m.setMediaId("啊實打實");
			HttpEntity<MessageBody4WX> entity = new HttpEntity<MessageBody4WX>(
					m, headers);

			System.out.println(template
					.postForObject(uri, entity, String.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public String demo4() {
		String str="Ffg7NXqoH79r2j5hY3iP3XVY0Qm3Wj97Ii1vGCkhYvtg7R0lImuyAE12201LMNni51xJMvjlRBFA9XpD+GAGCK/M7lOx9mYitbknotiqhQF6FmlW4LTrlszF1DgwIRgb6fga6/dhaFpaAAqMDHBUAzwLTrJ7idourZYI5+B+03kY9FUYnIK5gB2xsAibRdbCDIaKvwsKtSOuryBhizuP1uz/tf1sjiE5j8VkMmAvulAHqzv8wOhINP/O9n2OeW5vA7OLQWecmlyBXarxRl/630qm7AnIvUO+SDLNDhi6XJAqbyFbUfDOLgIXNmV5tpO+l4EgLKCjGX5/3mnuWGSgtZVF8cEZXUitoG1bUWhWTAXhAwDtXy+yeLxr7wi3QM3TAIgBATYwxGlFlf5PKZIeqC2rny/IDqQhWHFG/4hIlz8=";
		return str;
		
	}

}
