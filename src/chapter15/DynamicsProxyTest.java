package chapter15;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject{
	public void rent();
	public void hello(String arg);
}

class RealSubject implements Subject{

	@Override
	public void rent() {
		// TODO Auto-generated method stub
		System.out.println("I want to rent my house");
	}

	@Override
	public void hello(String arg) {
		// TODO Auto-generated method stub
		System.out.println("hello" + arg);
	}	
}

class SubjectDynamicsProxyGenerator implements InvocationHandler{
	private Subject subject;
	
	
	public SubjectDynamicsProxyGenerator(Subject subject) {
		super();
		this.subject = subject;
	}


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before rent house");
		System.out.println("Mathod:" + method);
		method.invoke(subject, args);
		System.out.println("after rent house");
		return null;
	}
	
	
	
}

public class DynamicsProxyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InvocationHandler handler = new SubjectDynamicsProxyGenerator(new RealSubject());
		Subject sb = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), RealSubject.class.getInterfaces(), handler);
		System.out.println(sb.getClass().getName());
		sb.rent();
		sb.hello("xiaolian");
	}

}
