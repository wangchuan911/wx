package my.hehe.service.parser;

import java.util.ArrayList;
import java.util.List;

import my.hehe.entity.HtmlInfo;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;

public class HtmlHandler implements DefaultHandler {

	public List<Object> parse(Document doc) {
		List<Object> result = new ArrayList<Object>();
		Elements elements = doc.getElementsByClass("prolist");
		for (Element datas : elements) {
			try {
				long id = Long.parseLong(datas.getElementsByClass("post")
						.get(0).attr("id"));
				String href = null;
				String date = null;
				String info = null;

				// *********定位查找************
				Elements body = datas.getElementsByClass("post-header");
				List<Node> values = body.get(0).childNodes();

				// System.out.println("&&&" + id);
				// System.out.println("&&&" + values.get(0).attr("href"));
				// System.out.println("&&&"
				// + values.get(2).childNode(0).childNode(0).outerHtml());
				// System.out.println("&&&"
				// + values.get(5).childNode(0).childNode(0).outerHtml());

				href = values.get(0).attr("href");
				date = values.get(2).childNode(0).childNode(0).outerHtml();
				info = values.get(5).childNode(0).childNode(0).outerHtml();
				result.add(new HtmlInfo(id, href, date, info));
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			// *********模糊搜索************
			// Elements element2 = datas.getElementsByClass("post-header");
			// for (Element element3 : element2) {
			// for (Node node : element3.childNodes()) {
			// //System.out.println("!!!!!!!!" + node.nodeName() + ":"
			// // + node);
			// if (node.nodeName().equals("a")) {
			// System.out.println("#access:"
			// + node.attributes().get("href"));
			// } else if (node.nodeName().equals("div")) {
			// System.out.println("@contont:"
			// + node.childNodes().get(0).childNode(0)
			// .outerHtml());
			// } else {
			// continue;
			// }
			// }
			// }
		}
		return result;
	}

	public <T> List<T> parse4Template(Document doc, Class<T> t) {
		List<T> result = new ArrayList<T>();
		Elements elements = doc.getElementsByClass("prolist");
		for (Element datas : elements) {
			try {
				long id = Long.parseLong(datas.getElementsByClass("post")
						.get(0).attr("id"));
				String href = null;
				String date = null;
				String info = null;

				// *********定位查找************
				Elements body = datas.getElementsByClass("post-header");
				List<Node> values = body.get(0).childNodes();
				href = values.get(0).attr("href");
				date = values.get(2).childNode(0).childNode(0).outerHtml();
				info = values.get(5).childNode(0).childNode(0).outerHtml();
				result.add(t.getConstructor(long.class, String.class,
						String.class, String.class).newInstance(id, href, date,
						info));
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
		}
		return result;
	}
}
