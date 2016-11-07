package my.hehe.service.parser;

import java.util.List;

import org.jsoup.nodes.Document;

public interface DefaultHandler {

	public List<Object> parse(Document doc);

	public <T> List<T> parse4Template(Document doc, Class<T> t);
}
