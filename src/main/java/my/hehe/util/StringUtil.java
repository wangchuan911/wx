package my.hehe.util;

import java.util.Map;

public class StringUtil {
public static String Format(String str,Map<Object, Object> value){
	Object[] keys=value.keySet().toArray();
	int[][] loc=new int[keys.length][2];
	StringBuffer sb=new StringBuffer(str);
	for (int i = 0; i < keys.length; i++) {
		loc[i][0]=str.lastIndexOf(keys[i].toString());
		loc[i][1]=loc[i][0]+value.get(keys[i]).toString().length()+1;
	}
	StringBuffer result=new StringBuffer();
	result.append(sb.substring(0, loc[0][0]));
	int i=0;
	for (i = 0; i < keys.length-1; i++) {
		result.append(value.get(keys[i]));
		result.append(sb.substring(loc[i][1],loc[i+1][0]));
	}
	result.append(value.get(keys[i]));
	result.append(sb.substring(loc[i][1]));
	return result.toString();
}
}
