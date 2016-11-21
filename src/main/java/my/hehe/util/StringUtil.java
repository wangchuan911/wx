package my.hehe.util;

import java.util.Map;

public class StringUtil {
	public static String FormatReplace(String str, Map<String, String> map) {
		// try {
		//
		// Object[] keys = map.keySet().toArray();
		// int[][] loc = new int[keys.length][2];
		// StringBuffer sb = new StringBuffer(str);
		// for (int i = 0; i < keys.length; i++) {
		// StringBuffer value = new StringBuffer("{").append(
		// keys[i].toString()).append("}");
		// int prefix = sb.lastIndexOf(value.toString());
		// // int len = map.get(keys[i]).toString().length() + 2;
		// int suffix = prefix + value.length();
		// // System.out.println(prefix + ":" + suffix + ":" + len);
		// if (prefix == -1 || suffix == 1 ) {
		// return sb.toString();
		// }
		// sb.delete(prefix, suffix);
		// sb.insert(prefix, map.get(keys[i]));
		// }
		// return sb.toString();
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// return str;
		return FormatReplace(str, map, "", "");

	}

	public static String FormatReplace(String str, Map<String, String> map,
			String prefix_str, String suffix_str) {
		StringBuffer sb = null;
		try {

			Object[] keys = map.keySet().toArray();
			sb = new StringBuffer(str);
			for (int i = 0; i < keys.length; i++) {
				while (true) {
					StringBuffer value = new StringBuffer(prefix_str).append(
							keys[i].toString()).append(suffix_str);
					
					if(new StringBuffer(map.get(keys[i])).indexOf(value.toString())!=-1){
						throw new Exception();
					}
					
					int prefix = sb.lastIndexOf(value.toString());
					int suffix = prefix + value.length();
					// System.out.println(prefix + ":" + suffix);
					
					if (prefix == -1) {
						break;
					}
					
					sb.delete(prefix, suffix);
					// System.out.println(sb);
					sb.insert(prefix, map.get(keys[i]));
					// System.out.println(sb);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();

	}

//	public static void main(String[] args) {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("c", "C!!!");
//		map.put("a", "A@@@");
//		map.put("b", "B");
//		map.put("d", "d---");
//
//		String str = "aaaaa{a}bbbbb{b}c{c}dddd{d}ddddd{d}";
//		System.out.println(StringUtil.FormatReplace(str, map,"{","" ));
//		// System.out.println(StringUtil.Format(str, map,"{","}"));
//
//	}
}
