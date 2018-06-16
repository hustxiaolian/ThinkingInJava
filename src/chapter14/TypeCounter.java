package chapter14;

import java.util.HashMap;
import java.util.Map;

public class TypeCounter extends HashMap<Class<?>, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6842816416213331388L;

	private Class<?> baseType;
	public TypeCounter(Class<?> baseType) {
		this.baseType = baseType;
	}
	
	public void count(Object obj) {
		Class<?> type = obj.getClass();
		if(!baseType.isAssignableFrom(type))
			throw new RuntimeException(obj + "incorrect type:" + type + ",should be type or subtype of " + baseType);
		countClass(type);
	}

	private void countClass(Class<?> type) {
		Integer value = get(type);
		put(type, value == null ? 1 : value + 1);
		Class<?> superClass = type.getSuperclass();
		if(superClass != null && baseType.isAssignableFrom(superClass))
			countClass(superClass);
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer("{");
		for(Map.Entry<Class<?>, Integer> pair : entrySet()) {
			sb.append(pair.getKey().getSimpleName());
			sb.append("=");
			sb.append(pair.getValue());
			sb.append(",");
		}
		sb.delete(sb.length() - 2, sb.length());
		sb.append("}");
		return sb.toString();
	}
}
