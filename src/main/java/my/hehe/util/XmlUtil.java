package my.hehe.util;

import java.io.InputStream;
import java.io.OutputStreamWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlUtil {
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

}
