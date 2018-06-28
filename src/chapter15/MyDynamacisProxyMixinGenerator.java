package chapter15;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class MyDynamacisProxyMixinGenerator implements InvocationHandler {
	private Map<String, Object> map;//��Ϊ��invoke�����У�����֪������������Ķ���StringΪ��������ObjectΪ����������Ƕ���
	//�����������ͱ���������ӳ���ϵ������invoke������
	
	public MyDynamacisProxyMixinGenerator(Object[] objs, Class<?>[] MixinInterfaceclasses) {
		map = new HashMap<>();
		int n = objs.length;
		for(int i = 0;i < n;++i) {
			for(Method m : MixinInterfaceclasses[i].getMethods()) {
				String methodName = m.getName();
				if(!map.containsKey(methodName))
					map.put(methodName, objs[i]);
			}
		}
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before...");
		Object proxyed = map.get(method.getName());
		System.out.println("after...");
		return method.invoke(proxyed, args);
	}
	
	public static Object newInstance(Object[] objs, Class<?>[] MixinInterfaceclasses) {
		return Proxy.newProxyInstance(MyDynamacisProxyMixinGenerator.class.getClassLoader(), MixinInterfaceclasses, 
				new MyDynamacisProxyMixinGenerator(objs, MixinInterfaceclasses));
	}
	
	public static void main(String[] args) {
		Object mixin = MyDynamacisProxyMixinGenerator.newInstance(
				new Object[] {new BasicImp(), new TimeStampedImp(), new SearilNumberedImp()}, new Class<?>[] {Basic.class, TimeStamped.class, SerialNumbered.class});
		Basic b = (Basic) mixin;
		b.set("xiaolian");
		b.get();
		TimeStamped t = (TimeStamped) mixin;
		t.getTimeStamp();
		SerialNumbered s = (SerialNumbered) mixin;
		s.getSearialNumber();
	}

}
