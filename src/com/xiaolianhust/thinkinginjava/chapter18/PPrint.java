package com.xiaolianhust.thinkinginjava.chapter18;

import java.util.Arrays;
import java.util.Collection;


public class PPrint {
	public static String pformat(Collection<?> c) {
		if(c.size() == 0) return "[]";
		StringBuffer sb = new StringBuffer("[");
		for(Object element : c) {
			if(c.size() != 1)
				sb.append("\n ");
			sb.append(element);
		}
		if(c.size() != 1)
			sb.append("\n ");
		sb.append("]");
		return sb.toString();
	}
	
	public static void pprint(Collection<?> c) {
		System.out.println(pformat(c));
	}
	
	public static void pprint(Object[] c) {
		System.out.println(Arrays.asList(c));
	}
}
