package my.hehe.filter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class HttpEncryptFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		chain.doFilter(new AuthenticationRequestWrapper(
				(HttpServletRequest) request), response);
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

}

class AuthenticationRequestWrapper extends HttpServletRequestWrapper {
	private HttpServletRequest request;

	public AuthenticationRequestWrapper(HttpServletRequest request)
			throws AuthenticationException {
		super(request);
		this.request = request;
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		
		final StringBuilder sb = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			// read the payload into the StringBuilder 
			InputStream inputStream = request.getInputStream();
			System.out.println(((ServletInputStream)inputStream).isFinished());
			System.out.println(((ServletInputStream)inputStream).isReady());
			
			System.out.println(inputStream.getClass().getName());
			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(
						inputStream));
				char[] charBuffer = new char[128];
				int bytesRead = -1;
				while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
					sb.append(charBuffer, 0, bytesRead);
				}
			} else {
				sb.append("");
			}
			
		} catch (IOException ex) {
			throw new AuthenticationException(
					"Error reading the request payload", ex);
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException iox) {
					// ignore 
				}
			}
		}
		System.out.print("filter get the request body:");
		System.out.println(sb.toString());

		byte[] buffer = null;

		try {
			buffer = sb.toString().getBytes("UTF-8");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return super.getInputStream();
		}
		final ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
		ServletInputStream newStream = new ServletInputStream() {

			@Override
			public int read() throws IOException {
				return bais.read();
			}

			@Override
			public boolean isFinished() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean isReady() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void setReadListener(ReadListener listener) {
				// TODO Auto-generated method stub

			}
		};

		return newStream;
	}

	// http://blog.chinaunix.net/uid-20783755-id-4729940.html
}
class AuthenticationResponseWrapper extends HttpServletResponseWrapper {

	HttpServletResponse response=null;
	public AuthenticationResponseWrapper(HttpServletResponse response) {
		super(response);
		this.response=response;
		// TODO Auto-generated constructor stub
	}
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return super.getOutputStream();
	}
	
}