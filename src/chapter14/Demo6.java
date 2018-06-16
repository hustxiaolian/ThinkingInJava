package chapter14;

import java.util.HashMap;
import java.util.Map;

public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SweetShop.main(args);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class Candy {
	static {System.out.println("Loading candy");}
}

class Gum {
	static {System.out.println("loading gum");}
}

class Cookie {
	static {System.out.println("loading cookie");}
}

class SweetShop{
	private static final String bagPath = "chapter14.";
	private static final String[] names = {"Candy","Gum","Cookie"};
	private static Map<String, String> map = new HashMap<>();
	static {
		for (String string : names) {
			map.put(string, bagPath + string);
		}
	}
	public static void main(String[] args) throws ClassNotFoundException {
		for(String currName : args) {
			if(map.get(currName) != null) {
				Class<?> clazz = Class.forName(map.get(currName));
				System.out.println(clazz.getName() + "have loaded.");
			}
			else {
				System.out.println("该类不存在");
			}
		}
	}
}