package my.hehe.filter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.security.sasl.AuthenticationException;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.springframework.beans.factory.annotation.Value;

abstract class AuthenticationRequestWrapper extends HttpServletRequestWrapper {
	@Value("${weixin.token}")
	private String apptoken;

	private HttpServletRequest request;

	private boolean isHandleRequest = false;

	public AuthenticationRequestWrapper(HttpServletRequest request)
			throws AuthenticationException {
		super(request);
		this.request = request;
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		if (!isHandleRequest) {
			return request.getInputStream();
		}
		final StringBuilder sb = new StringBuilder();
		BufferedReader bufferedReader = null;
		try {
			// read the payload into the StringBuilder 
			InputStream inputStream = request.getInputStream();

			if (inputStream != null) {
				bufferedReader = new BufferedReader(new InputStreamReader(
						inputStream, request.getCharacterEncoding()));
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

		byte[] buffer = null;
		try {
			buffer = doFilterBeforeHandler(sb.toString(), request).getBytes(
					request.getCharacterEncoding());
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
	public final void doFilterBefore() {
		isHandleRequest = true;
	}

	abstract String doFilterBeforeHandler(String data, HttpServletRequest request) ;
}
