package my.hehe.entity;

public class HtmlInfo {
	private long id;
	private String href;
	private String createDate;
	private String info;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public HtmlInfo(long id, String href, String createDate, String info) {
		super();
		this.id = id;
		this.href = href;
		this.createDate = createDate;
		this.info = info;
	}

	public HtmlInfo() {

	}
@Override
public String toString() {
	StringBuffer sb=new StringBuffer("{\"id\":\"").append(id).append("\",\"href\":\"").append(href).append("\",\"date\":\"").append(createDate).append("\",\"info\":\"").append(info).append("\"}");
	return sb.toString();
}
}
