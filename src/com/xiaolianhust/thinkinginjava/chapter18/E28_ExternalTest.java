package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.BufferedOutputStream;
import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Blip1 implements Externalizable{
	public Blip1() {
		System.out.println("Blip1 constructor");
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Blip1 readExternal");
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Blip1 writeExternal");
	}
}

class Blip2 implements Externalizable{
	
	Blip2() {
		System.out.println("Blip2 constructor");
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Blip2 readExternal");
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Blip2 writeExternal");
	}
	
}

public class E28_ExternalTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		//д���ļ���
		Blip1 b1 = new Blip1();
		Blip2 b2 = new Blip2();
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(".\\Source\\18E28"));
		out.writeObject(b1);
		out.writeObject(b2);
		out.close();
		//���ļ����ع�����
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(".\\Source\\18E28"));
		b1 = (Blip1) in.readObject();
		b2 = (Blip2) in.readObject();
		
		/*
		 * �ӽ���У����ǿ��������ؿ���ʵ����Exterbalizable�ӿڵĶ������ع�ʱ���ȵ���Ĭ�Ϲ��캯����Ȼ����readExternalizable��
		 * ��Ȼд���ļ�ʱ�����ǵ���writeExternal() 
		 * 
		 * ͬʱ�����Ǳ����ֶ�����Ĭ�Ϲ���ʱpublic�ģ�ע�͵��޲ι��캯����ʹ�ñ�����Ĭ���ṩ�Ĺ��캯���������׳�
		 * java.io.InvalidClassException
		 */
		
	}

}
