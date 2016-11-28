package my.hehe.filter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.annotation.Resource;
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
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import my.hehe.entity.message.EncryptMessageBody4WX;
import my.hehe.entity.message.MessageBody4WX;
import my.hehe.util.WXApi;

@Repository
public class HttpEncryptFilter implements Filter {
	@Autowired(required = true)
	private WXApi api;

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		AuthenticationRequestWrapper requestWrapper=new AuthenticationRequestWrapper(
				(HttpServletRequest) request);
		AuthenticationResponseWrapper responseWrapper = new AuthenticationResponseWrapper(
				(HttpServletResponse) response);
		// before
		chain.doFilter(requestWrapper,responseWrapper);
		// after

		byte[] response_body = responseWrapper.getResponseData();
		System.out.print("filter get the response body:");
		System.out.println(new String(response_body, response
				.getCharacterEncoding()));
		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
			out.write(response_body);
			out.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		// finally {
		// if (out != null) {
		// out.close();
		// }
		// }

	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public static void objectToXmlStr(Object obj,
			@SuppressWarnings("rawtypes") Class beanClass, OutputStreamWriter os)
			throws Exception {
		JAXBContext context = JAXBContext.newInstance(beanClass);
		// 根据上下文获取marshaller对象
		Marshaller marshaller = context.createMarshaller();
		// 设置编码字符集
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		// 格式化XML输出，有分行和缩进
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		// 打印到控制台
		marshaller.marshal(obj, os);
	}

	@SuppressWarnings("unchecked")
	public static <T> T xmlStrToObject(InputStream is, Class<T> beanClass)
			throws Exception {
		// T bean = beanClass.newInstance();
		JAXBContext context = JAXBContext.newInstance(beanClass);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		T bean = (T) unmarshaller.unmarshal(is);
		return bean;
	}

	public static String MessageConverter(HttpServletRequest request,
			String data,WXApi api) throws UnsupportedEncodingException, Exception {
		Map<String, String[]> map = request.getParameterMap();
		for (String str : map.keySet()) {
			System.out.println(str + ":" + map.get(str)[0]);
		}
		String data4b = xmlStrToObject(
				new ByteArrayInputStream(data.getBytes(request
						.getCharacterEncoding())), EncryptMessageBody4WX.class)
				.getEncrypt();
		String a = map.get("signature")[0];
		String b = map.get("timestamp")[0];
		String c = map.get("nonce")[0];
		System.out.println(a+":"+b+":"+c+":"+data4b+":"+api);
		return api.decryptMsg(a, b, c, data4b);
	}
}

class AuthenticationRequestWrapper extends HttpServletRequestWrapper {
	private HttpServletRequest request;
	private WXApi api;
	public void setApi(WXApi api) {
		this.api = api;
	}

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
			// System.out.println(((ServletInputStream)
			// inputStream).isFinished());
			// System.out.println(((ServletInputStream) inputStream).isReady());
			// System.out.println(inputStream.getClass().getName());
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
			// System.out.println(((ServletInputStream)
			// inputStream).isFinished());
			// System.out.println(((ServletInputStream) inputStream).isReady());
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
		try {

			System.out.println(HttpEncryptFilter.MessageConverter(request,
					sb.toString(),api));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		byte[] buffer = null;

		try {
			buffer = sb.toString().getBytes(request.getCharacterEncoding());

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

	private ByteArrayOutputStream buffer = null;
	private ServletOutputStream out = null;
	private PrintWriter writer = null;

	public AuthenticationResponseWrapper(HttpServletResponse response)
			throws IOException {
		super(response);
		buffer = new ByteArrayOutputStream();
		out = new WapperedOutputStream(buffer);
		writer = new PrintWriter(new OutputStreamWriter(buffer,
				this.getCharacterEncoding()));
		// TODO Auto-generated constructor stub
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		// TODO Auto-generated method stub
		return writer;
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		// TODO Auto-generated method stub
		return out;
	}

	@Override
	public void flushBuffer() throws IOException {
		// TODO Auto-generated method stub
		if (out != null) {
			out.flush();
		}
		if (writer != null) {
			writer.flush();
		}
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		buffer.reset();
	}

	public byte[] getResponseData() throws IOException {
		flushBuffer();
		return buffer.toByteArray();
	}

	private class WapperedOutputStream extends ServletOutputStream {
		private ByteArrayOutputStream bos = null;

		public WapperedOutputStream(ByteArrayOutputStream stream)
				throws IOException {
			bos = stream;
		}

		@Override
		public void write(int b) throws IOException {
			bos.write(b);
		}

		@Override
		public void write(byte[] b) throws IOException {
			bos.write(b, 0, b.length);
		}

		@Override
		public boolean isReady() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void setWriteListener(WriteListener arg0) {
			// TODO Auto-generated method stub

		}
	}

}