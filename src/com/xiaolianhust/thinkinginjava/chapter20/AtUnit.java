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
			//�����չ����ΪʲôҪ��@Test����ǣ����ڿ��Լ���һ��timeout����ͦ����ģ��������Լ�������
			if(m.getAnnotation(Test.class) == null) {
				return;
			}
			if(!(m.getReturnType().equals(boolean.class) || m.getReturnType().equals(void.class))) {
				throw new RuntimeException("@Test Method muset return boolean or void");
			}
			m.setAccessible(true);//������private��������һ����Ҳ����ֱ�Ӷ���ɼ�
			add(m);
		}
	}
	
	/**
	 * 1.���ȼ��÷����Ƿ���@TestObjectCreator��ǵķ���
	 * 2.���÷������ص��Ƿ���void����boolean
	 * 3.���÷����Ƿ���static����
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
		//���ݴ����File������jvm������������ظ�class��ִ�����о�̬��䣬����class������Ϣ
		String cName = file.getName();
		try {
			testClass = Class.forName(cName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//���÷����������ȡ��������з��������Ҽ����Щ������@Test��ǣ�����ǵķ�������testmethod������
		TestMethods testMethods = new TestMethods();
		Method creator = null;
		Method cleanup = null;
		for(Method m : testClass.getDeclaredMethods()) {
			testMethods.add(m);//���������@Test��ǵļ��
			if(creator == null) {//�״μ�鵽@TestObjectCreator��@TestObjectCleanup�������ж���ȷ��Ͳ��ټ���ˡ�
				creator = checkForCreatorMethod(m);
			}
			if(cleanup == null) {
				cleanup = checkForCleaupMethod(m);
			}
		}
		
		//�ж��Ƿ���creator�������еĻ�ִ��
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
		
		//�����洢�����б�Ǻ�@Test�ķ���
		for(Method m : testMethods) {
			System.out.println("  .  " + m.getName() + " ");
			try {
				Object testObject = createTestObject(creator);
				boolean success = false;
				//�ж�@Test��ǵķ����ķ������ͣ�Ȼ��������ͬ�Ľ������
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



