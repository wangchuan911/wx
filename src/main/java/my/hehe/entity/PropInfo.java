package my.hehe.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
@Repository
public class PropInfo {
	@Value("${weixin.appID}")
	private String appID;

	@Value("${weixin.appsecret}")
	private String appsecret;

	@Value("${weixin.token}")
	private String apptoken;

	public String getAppID() {
		return appID;
	}

	public String getAppsecret() {
		return appsecret;
	}

	public String getApptoken() {
		return apptoken;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}

	public void setApptoken(String apptoken) {
		this.apptoken = apptoken;
	}

	
}
