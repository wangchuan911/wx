package my.hehe.entity.message;

import java.lang.reflect.Field;

import my.hehe.entity.message.receive.MessageBody4WX;
import my.hehe.entity.message.send.xml.Message4WX;

public class MessageCreater {
	// public static <T extends Message4WX> T messageConverter(
		// MessageBody4WX body, Class<T> clazz) {
		//
		// try {
		// Map<String, Field> clazz_map = new HashMap<String, Field>();
		// Field[] clazz_field = clazz.getDeclaredFields();
		//
		// for (Field field : clazz_field) {
		// field.setAccessible(true);
		// // System.out.println(field.getName());
		// clazz_map.put(field.getName(), field);
		//
		// }
		//
		// Class clazz_super = clazz.getSuperclass();
		// Field[] clazz_super_field = clazz_super.getDeclaredFields();
		//
		// for (Field field : clazz_super_field) {
		// field.setAccessible(true);
		// // System.out.println(field.getName());
		// clazz_map.put(field.getName(), field);
		// }
		// if (body == null) {
		// return null;
		// }
		// Class body_clazz = body.getClass();
		// T t = clazz.newInstance();
		// Set<String> clazz_field_name = clazz_map.keySet();
		// for (String field_name : clazz_field_name) {
		// Field body_field = body_clazz.getDeclaredField(field_name);
		// body_field.setAccessible(true);
		// clazz_map.get(field_name).set(t, body_field.get(body));
		// }
		// return t;
		// } catch (Exception e) {
		// // TODO: handle exception
		// e.printStackTrace();
		// }
		// return null;
		// }

		public static <T extends Message4WX> T messageConverter(
				MessageBody4WX body, Class<T> clazz) {
			if (body == null) {
				return null;
			}
			try {
				Class body_clazz = body.getClass();
				T t = clazz.newInstance();

				Field[] clazz_field = clazz.getDeclaredFields();
				Field[] clazz_super_field = clazz.getSuperclass()
						.getDeclaredFields();

				for (Field field : clazz_field) {
					field.setAccessible(true);
					Field body_clazz_field = body_clazz.getDeclaredField(field
							.getName());
					body_clazz_field.setAccessible(true);
					field.set(t, body_clazz_field.get(body));

				}
				for (Field field : clazz_super_field) {
					if (field.getName().equals("MsgType")) {
						continue;
					}
					field.setAccessible(true);
					Field body_clazz_field = body_clazz.getDeclaredField(field
							.getName());
					body_clazz_field.setAccessible(true);
					field.set(t, body_clazz_field.get(body));
				}
				return t;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			return null;
		}
}
