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
	 * ͨ���������ַ�ʽ�������Ƿ���Ȩ�޿��ƣ�˽���ڲ��࣬�����������ڲ��඼�޷���ֹ��
	 * ĳ�������ĵ���
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
