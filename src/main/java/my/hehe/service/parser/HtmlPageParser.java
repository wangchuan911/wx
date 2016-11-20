package my.hehe.service.parser;

import java.io.IOException;
import java.util.List;

import my.hehe.entity.HtmlInfo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlPageParser {

	public String parserUri;

	public static <T> List<T> H2OParse(String uri, DefaultHandler handler,
			Class<T> t) throws IOException {
		Document document = Jsoup.connect(uri).get();
		return handler.parse4Template(document, t);
	}

	public static void main(String[] args) {
		try {
			List<HtmlInfo> infos = H2OParse("http://www.tstdtz.com/tags/南宁停电通知",
					new HtmlHandler(),HtmlInfo.class);
			System.out.println(infos);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// public static void demo() {
	// Document document = null;
	// try {
	// document = Jsoup.connect("http://www.tstdtz.com/tags/南宁停电通知").get();
	// Elements elements = document.getElementsByClass("prolist");
	// for (Element datas : elements) {
	// long id = Long.parseLong(datas.getElementsByClass("post")
	// .get(0).attr("id"));
	// System.out.println("%%%" + id);
	// // *********定位查找************
	// Elements body = datas.getElementsByClass("post-header");
	// List<Node> values = body.get(0).childNodes();
	// System.out.println("&&&" + values.get(0).attr("href"));
	// System.out.println("&&&"
	// + values.get(2).childNode(0).childNode(0).outerHtml());
	// System.out.println("&&&"
	// + values.get(5).childNode(0).childNode(0).outerHtml());
	//
	// // *********模糊搜索************
	// // Elements element2 = datas.getElementsByClass("post-header");
	// // for (Element element3 : element2) {
	// // for (Node node : element3.childNodes()) {
	// // //System.out.println("!!!!!!!!" + node.nodeName() + ":"
	// // // + node);
	// // if (node.nodeName().equals("a")) {
	// // System.out.println("#access:"
	// // + node.attributes().get("href"));
	// // } else if (node.nodeName().equals("div")) {
	// // System.out.println("@contont:"
	// // + node.childNodes().get(0).childNode(0)
	// // .outerHtml());
	// // } else {
	// // continue;
	// // }
	// // }
	// // }
	// }
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// }
}
