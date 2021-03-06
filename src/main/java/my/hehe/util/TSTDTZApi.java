package my.hehe.util;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import my.hehe.entity.HtmlInfo;
import my.hehe.service.parser.HtmlHandler;
import my.hehe.service.parser.HtmlPageParser;

import org.springframework.beans.factory.annotation.Value;

public class TSTDTZApi {
//	private RestTemplate template;

	@Value("${tstdtz.tdtz}")
	private String tdtz_url;

//	public TSTDTZApi(RestTemplate template) {
//		this.template = template;
//	}

	public TSTDTZApi() {

	}

//	public void setTemplate(RestTemplate template) {
//		this.template = template;
//	}

	public List<HtmlInfo> TD(String location, int count,long time) {
		List<HtmlInfo> infos = null;
		try {

			StringBuffer str = new StringBuffer(tdtz_url);
			
			int prefix = str.indexOf("{", 0);
			int suffix = str.indexOf("}", prefix) + 1;
			

			StringBuffer url = new StringBuffer();
			url.append(str.substring(0, prefix)).append(location)
					.append(str.substring(suffix));
			int i=url.lastIndexOf("/");
			String encoder_str=URLEncoder.encode(url.substring(i+1).toString(),"utf-8");
			url.replace(i+1, encoder_str.length(), encoder_str);


			infos = HtmlPageParser.H2OParse(url.toString(), new HtmlHandler(),
					HtmlInfo.class);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		StringBuffer sb = new StringBuffer("[");
		if (infos != null) {
			int i;
			while((i=infos.size())>count){
				infos.remove(i-1);
			}
		}
		
		return infos;
	}

	public static void main(String[] args) throws IOException {
		//http://www.tstdtz.com/tags/南宁停电通知
//		TSTDTZApi api=new TSTDTZApi(new RestTemplate());
		TSTDTZApi api=new TSTDTZApi();
		api.tdtz_url="http://www.tstdtz.com/tags/{location}停电通知";
		System.out.println(api.TD("南宁", 5,0));
	}
}
