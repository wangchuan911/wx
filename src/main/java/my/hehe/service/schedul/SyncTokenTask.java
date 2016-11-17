package my.hehe.service.schedul;

import my.hehe.entity.Token;
import my.hehe.util.WXApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SyncTokenTask {
//	@Autowired(required = true)
//	public RestTemplate template;
	@Autowired(required = true)
	private WXApi api;
	@Autowired(required = true)
	private Token token;

	@Scheduled(initialDelay = 0, fixedDelay = 1000 * 60 * 90)
	// cron = "*/10 * * * * ?"
	// "1/5 * * * * ?"
	public void schedulSyncToken() {
		
		System.out.println(api.getToken());
	}


}
