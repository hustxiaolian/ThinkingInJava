package chapter14;

import java.lang.reflect.Method;

import chapter14.packageaccess.HiddenC;

public class HiddenImplementation {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		A a = HiddenC.makeA();
		callHiddenMathod(a, "w");
	}
	
	/**
	 * 通过反射这种方式，无论是访问权限控制，私有内部类，或者是匿名内部类都无法阻止对
	 * 某个方法的调用
	 * @param a
	 * @param methodName
	 * @throws Exception
	 */
	static void callHiddenMathod(Object a, String methodName) throws Exception {
		Method m = a.getClass().getDeclaredMethod(methodName);
		m.setAccessible(true);
		m.invoke(a);
	}	

}
