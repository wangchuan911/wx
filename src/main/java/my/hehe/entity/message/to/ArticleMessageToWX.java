package my.hehe.entity.message.to;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import my.hehe.entity.message.from.MessageFromWX;
import my.hehe.util.WXType;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ArticleMessageToWX extends MessageToWX {

	@XmlElement(name = "ArticleCount")
	private int ArticleCount;

	@XmlElementWrapper(name = "Articles")
	@XmlElement(name = "item")
	private final List<Article> articles = new ArrayList<Article>();

	public void setArticleInfo(String Title, String Description, String PicUrl,
			String Url) {
		Article article = new Article();
		article.setTitle(Title);
		article.setDescription(Description);
		article.setPicUrl(PicUrl);
		article.setUrl(Url);
		this.articles.add(article);
		this.ArticleCount = articles.size();

	}

	public ArticleMessageToWX() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticleMessageToWX(MessageFromWX msg, Long createTime) {
		super(msg, createTime, WXType.ARTICLE);

		// TODO Auto-generated constructor stub
	}

	public ArticleMessageToWX(MessageFromWX msg) {
		super(msg, WXType.ARTICLE);
		// TODO Auto-generated constructor stub
	}

	public ArticleMessageToWX(String toUserName, String fromUserName,
			Long createTime) {
		super(toUserName, fromUserName, createTime, WXType.ARTICLE);
		// TODO Auto-generated constructor stub
	}

	public ArticleMessageToWX(String toUserName, String fromUserName) {
		super(toUserName, fromUserName, WXType.ARTICLE);
		// TODO Auto-generated constructor stub
	}

}

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
class Article {

	@XmlElement(name = "MediaId")
	private String Title;
	@XmlElement(name = "Description")
	private String Description;
	@XmlElement(name = "PicUrl")
	private String PicUrl;
	@XmlElement(name = "Url")
	private String Url;

	public String getTitle() {
		return Title;
	}

	public String getDescription() {
		return Description;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public String getUrl() {
		return Url;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public void setDescription(String description) {
		Description = description;
	}

}