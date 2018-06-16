package chapter14;
import java.lang.reflect.Field;
import java.util.ArrayList;
public class Demo8 {

	public static void main(String[] args) {
		
		printAllClassInfo(new ArrayList<>());
	}
	
	public static void printAllClassInfo(Object obj) {
		recursionPrint(obj.getClass(), 0);
	}
	
	/**
	 * �ݹ�Ĵ�ӡ���еļ̳���
	 * @param cls
	 */
	public static void recursionPrint(Class<?> cls, int tabNum) {
		if(cls == null) return;
		System.out.println(tabNum + ":");
		System.out.println(cls.getName());
		for(Class<?> k : cls.getInterfaces()) {
			System.out.println("  Interface:" + k.getName());
			recursionPrint(k.getSuperclass(), tabNum + 1);
		}
		//���ȴ�ӡ����
		recursionPrint(cls.getSuperclass(), tabNum + 1);
		
	}
	
	
	public static void printDeclaredFields(Class<?> cls) {
		if(cls == null) return;
		System.out.println(cls.getName());
		for(Class<?> field : cls.getDeclaredClasses()) {
			
		}
	}
}
