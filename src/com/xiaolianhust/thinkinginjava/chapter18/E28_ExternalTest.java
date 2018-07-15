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
		//写入文件中
		Blip1 b1 = new Blip1();
		Blip2 b2 = new Blip2();
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(".\\Source\\18E28"));
		out.writeObject(b1);
		out.writeObject(b2);
		out.close();
		//从文件中重构对象
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(".\\Source\\18E28"));
		b1 = (Blip1) in.readObject();
		b2 = (Blip2) in.readObject();
		
		/*
		 * 从结果中，我们可以清晰地看到实现了Exterbalizable接口的对象在重构时，先调用默认构造函数，然后再readExternalizable，
		 * 当然写入文件时，就是调用writeExternal() 
		 * 
		 * 同时，我们必须手动声明默认构造时public的，注释掉无参构造函数后，使用编译器默认提供的构造函数，将会抛出
		 * java.io.InvalidClassException
		 */
		
	}

}
