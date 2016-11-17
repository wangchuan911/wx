package my.hehe;

import java.util.Date;

import my.hehe.entity.receive.Message4WX2;
import my.hehe.entity.receive.TextMessage4WX;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

public class Test {
	public static void main(String[] args) {
		demo2();

	}

	public static void demo() {
		try {
			String uri = "http://localhost:8080/receive";
			RestTemplate template = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_XML);
//			HttpEntity<TextMessage4WX> entity = new HttpEntity<TextMessage4WX>(
//					new TextMessage4WX("hehe", "haha", new Date().getTime(),
//							"text", "aaa", "1"), headers);
			HttpEntity<Message4WX2> entity = new HttpEntity<Message4WX2>(
					new Message4WX2("hehe", "haha", new Date().getTime(),
							"text",  "1"), headers);
			System.out.println(template
					.postForObject(uri, entity, String.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void demo2() {
		try {
			String uri = "http://localhost/receive";
			RestTemplate template = new RestTemplate();
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_XML);
			System.out.println(headers);
			HttpEntity<TextMessage4WX> entity = new HttpEntity<TextMessage4WX>(
					new TextMessage4WX("hehe", "haha", new Date().getTime(),
							"text", "aaa", "1"), headers);

			System.out.println(template
					.postForObject(uri, entity, String.class));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
