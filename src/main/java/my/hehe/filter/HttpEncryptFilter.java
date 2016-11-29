package my.hehe.filter;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import my.hehe.util.WXApi;

@Service
public class HttpEncryptFilter implements Filter {
	@Resource
	private WXApi api;

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		StopWatch watch = new StopWatch();
		watch.start();
		
		final WXApi api = this.api;
		final String timestamp = request.getParameter("timestamp");
		final String nonce = request.getParameter("nonce");

		AuthenticationRequestWrapper requestWrapper = new AuthenticationRequestWrapper(
				(HttpServletRequest) request) {

			@Override
			String doFilterBeforeHandler(String data, HttpServletRequest request) {
				{
					String dencrypt = null;
					try {
						dencrypt = api.decryptMsg(
								request.getParameter("msg_signature"),
								request.getParameter("timestamp"),
								request.getParameter("nonce"), data);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						dencrypt = data;
					}
					return dencrypt;
				}
			}
		};
		
		watch.stop();
		System.out.println("doFilterBeforeHandler init:"+watch.getTotalTimeSeconds());
		watch.start();
		
		AuthenticationResponseWrapper responseWrapper = new AuthenticationResponseWrapper(
				(HttpServletResponse) response) {

			@Override
			public void doFilterAfter(HttpServletResponse response) {
				ServletOutputStream out=null;
				try {
					String response_body = new String(getResponseData(),response.getCharacterEncoding());
					String ecrypt;
					if (response_body.equals("success")) {
						ecrypt = response_body;
					} else {
						ecrypt = api.ecryptMsg(response_body, timestamp, nonce);
					}
					out = response.getOutputStream();
					try {
						out.write(ecrypt.getBytes(response.getCharacterEncoding()));
					} catch (Exception e) {
						e.printStackTrace();
						out.write("success".getBytes(response.getCharacterEncoding()));
					}
					out.flush();
				} catch (Exception e) {					
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		};
		
		watch.stop();
		System.out.println("doFilterAfter init:"+watch.getTotalTimeSeconds());
		watch.start();
		// before
		requestWrapper.doFilterBefore();
		
		watch.stop();
		System.out.println("doFilterBefore:"+watch.getTotalTimeSeconds());
		watch.start();
		// do filter
		chain.doFilter(requestWrapper, responseWrapper);
		
		watch.stop();
		System.out.println("doFilter:"+watch.getTotalTimeSeconds());
		watch.start();
		// after
		responseWrapper.doFilterAfter((HttpServletResponse) response);
		
		watch.stop();
		System.out.println("doFilterAfter:"+watch.getTotalTimeSeconds());

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}
