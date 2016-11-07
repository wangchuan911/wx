package my.hehe.entity;

import org.springframework.stereotype.Repository;

@Repository
public class Token {
	private String access_token;
	private String expires_in;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer("{\"access_token\":\"").append(access_token).append("\",\"expires_in\":\"").append(expires_in).append("\"}");
		return sb.toString();
	}
}
