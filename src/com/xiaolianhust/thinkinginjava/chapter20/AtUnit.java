package com.xiaolianhust.thinkinginjava.chapter20;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class AtUnit {
	static Class<?> testClass;
	static List<String> failTest;
	static long testsRun = 0;
	static long failures = 0;
	
	static class TestMethods extends ArrayList<Method>{
		void adddIfTestMethod(Method m) {
			//这里就展现了为什么要用@Test来标记，后期可以加上一个timeout还是挺不错的，哈哈我自己来改造
			if(m.getAnnotation(Test.class) == null) {
				return;
			}
			if(!(m.getReturnType().equals(boolean.class) || m.getReturnType().equals(void.class))) {
				throw new RuntimeException("@Test Method muset return boolean or void");
			}
			m.setAccessible(true);//哪怕是private方法，这一操作也让你直接对外可见
			add(m);
		}
	}
	
	/**
	 * 1.首先检查该方法是否是@TestObjectCreator标记的方法
	 * 2.检查该方法返回的是否是void或者boolean
	 * 3.检查该方法是否不是static方法
	 * 
	 * @param m
	 * @return
	 */
	private static Method checkForCreatorMethod(Method m) {
		if(m.getAnnotation(TestObjectCreate.class) == null) {
			return null;
		}
		if(!m.getReturnType().equals(testClass)) {
			throw new RuntimeException("@TestObjectCreate must return instance of class to be tested");
		}
		if((m.getModifiers() & java.lang.reflect.Modifier.STATIC) < 1){
			throw new RuntimeException("@TestObjectCreate must be static");
		}
		m.setAccessible(true);
		return m;
	}
	
	private static Method checkForCleaupMethod(Method m) {
		if(m.getAnnotation(TestObjectClean.class) == null)
			return null;
		if(!m.getReturnType().equals(void.class))
			throw new RuntimeException("@TestObjectCleanup must return void");
		if((m.getModifiers() & java.lang.reflect.Modifier.STATIC) < 1)
			throw new RuntimeException("@TestObjectCleanup must be static");
		if(m.getParameterTypes().length == 0 || m.getParameterTypes()[0] != testClass )
			throw new RuntimeException("@TestObjectCleanup must take an argument of the tested type");
		m.setAccessible(true);
		return m;
	}
	
	
	private static Object createTestObject(Method creator) {
		if(creator != null) {
			try {
				return creator.invoke(testClass);
			}
			catch(Exception e) {
				throw new RuntimeException("Couldn't run @TestObject (creator) method");
			}
		}
		else {
			try {
				return testClass.newInstance();
			} catch (Exception e) {
				throw new RuntimeException("Couldn't create a test object. Try using @TestObject method");
			}
		}
	}
	
	public void process(File file) {
		//根据传入的File对象，让jvm类加载器来加载该class，执行其中静态语句，返回class类型信息
		String cName = file.getName();
		try {
			testClass = Class.forName(cName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//利用反射机制来获取该类的所有方法，并且检查那些方法有@Test标记，将标记的方法放入testmethod容器中
		TestMethods testMethods = new TestMethods();
		Method creator = null;
		Method cleanup = null;
		for(Method m : testClass.getDeclaredMethods()) {
			testMethods.add(m);//这里完成了@Test标记的检查
			if(creator == null) {//首次检查到@TestObjectCreator和@TestObjectCleanup，并且判断正确后就不再检查了。
				creator = checkForCreatorMethod(m);
			}
			if(cleanup == null) {
				cleanup = checkForCleaupMethod(m);
			}
		}
		
		//判断是否有creator方法，有的话执行
		if(testMethods.size() > 0) {
			try {
				if(!Modifier.isPublic(testClass.getDeclaredConstructor().getModifiers())) {
					System.out.println("Error:" + testClass + "default constructor must be public");
					System.exit(1);
				}
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(testClass.getName());
		}
		
		//遍历存储的所有标记好@Test的方法
		for(Method m : testMethods) {
			System.out.println("  .  " + m.getName() + " ");
			try {
				Object testObject = createTestObject(creator);
				boolean success = false;
				//判断@Test标记的方法的返回类型，然后做出不同的结果处理
				if(m.getReturnType().equals(boolean.class)) {
					success = (boolean) m.invoke(testObject);
				}
				else {
					m.invoke(testObject);
					success = true;
				}
				
				System.out.println(success ? "" : "(failded)");
				testsRun++;
				if(!success ) {
					failures++;
					failTest.add(testClass.getName() + ": " + m.getName());
				}
				if(cleanup != null) {
					cleanup.invoke(testObject, testObject);
				}
			}
			catch(Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}



