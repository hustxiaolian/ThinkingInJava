package chapter15;

import java.util.HashMap;
import java.util.Map;

public class E21_ClassTypeCapture {
	private Map<String, Class<?>> map = new HashMap<>();
	
	public void addType(String typeName, Class<?> kind) {
		map.put(typeName, kind);
	}
	
	@SuppressWarnings("unchecked")
	public Object createNew(String typeName) {
		try {
			return  map.get(typeName).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		E21_ClassTypeCapture ctt = new E21_ClassTypeCapture();
		ctt.addType("Building", Building.class);
		System.out.println(ctt.createNew("Building"));
	}

}
