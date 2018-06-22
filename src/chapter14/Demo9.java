package chapter14;

import java.lang.reflect.Method;

public class Demo9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		showClassDeckaredMethod("chapter14.Position");
	}
	/**
	 * ˼·��ʹ��class.forName��̬�����ࡣ
	 * Ȼ��ʹ��Class�������ط�������ȡ��������Ϣ
	 * @param classPath
	 */
	public static void showClassDeckaredMethod(String classPath) {
		Class<?> cl = null;
		try {
			cl = Class.forName(classPath);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Method[] ms = cl.getDeclaredMethods();
		for(Method m : ms) {
			System.out.printf("Method Name:%s, Para count:%d\t", m.getName(), m.getParameterCount());
			for(Class<?> cls : m.getParameterTypes()) {
				System.out.print(cls.getSimpleName() + " ,");
			}
			System.out.println();
			System.out.println("-------------------");
		}
		
	}

}
