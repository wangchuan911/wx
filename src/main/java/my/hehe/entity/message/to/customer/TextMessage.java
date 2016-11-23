package my.hehe.entity.message.to.customer;



public class TextMessage extends Message {
	
	private  Text text;

	public Text getText() {
		return text;
	}

	public void setText(Text text) {
		this.text = text;
	}

	public TextMessage(String touser, String msgtype, Text text) {
		super(touser, msgtype);
		this.text = text;
		// TODO Auto-generated constructor stub
	}

	public TextMessage() {
	}

	public static class Text {
		protected String content;

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public Text(String content) {
			this.content = content;
		}

		public Text() {
		}
	}

}
