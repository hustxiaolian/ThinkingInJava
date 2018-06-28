package chapter15;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

class MixinProxy implements InvocationHandler{
	Map<String, Object> delegatesByMethod;//那个单词为委托的意思
	public MixinProxy(TwoTuple<Object,Class<?>>...pairs) {
		delegatesByMethod = new HashMap<>();
		for(TwoTuple<Object, Class<?>> pair : pairs) {
			for(Method m : pair.second.getMethods()) {
				String methodName = m.getName();
				if(!delegatesByMethod.containsKey(methodName))//将所有的方法都添加到map中
					delegatesByMethod.put(methodName, pair.first);
			}
		}
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		String methodName = method.getName();
		Object delegate = delegatesByMethod.get(methodName);
		return method.invoke(delegate, args);
	}
	
	@SuppressWarnings("rawtypes")
	public static Object newInstance(TwoTuple...pairs) {
		Class[] interfaces = new Class[pairs.length];
		for(int i = 0;i < pairs.length; ++i) {
			interfaces[i] = (Class) pairs[i].second;
		}
		
		ClassLoader cl = pairs[0].first.getClass().getClassLoader();
		return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
	}
	
}

public class DynamicsProxyMixin {
	public static void main(String[] args) {
		Object mixin = MixinProxy.newInstance(
				new TwoTuple<Object, Class<?>>(new BasicImp(), Basic.class),
				new TwoTuple<Object, Class<?>>(new TimeStampedImp(), TimeStamped.class),
				new TwoTuple<Object, Class<?>>(new SearilNumberedImp(), SerialNumbered.class));
		Basic b = (Basic) mixin;
		TimeStamped t = (TimeStamped) mixin;
		System.out.println(t.getTimeStamp());
	}
}
