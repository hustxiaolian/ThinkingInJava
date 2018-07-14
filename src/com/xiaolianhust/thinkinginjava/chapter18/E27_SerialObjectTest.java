package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class E27_One implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5724815306706882243L;
	private String xing;
	private E27_Two ming;
	
	public E27_One(String xing, String ming) {
		this.xing = xing;
		this.ming = new E27_Two(ming);
	}

	@Override
	public String toString() {
		return xing + ming.toString();
	}
	
	
	
}

class E27_Two implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6618385556398753134L;
	
	public String ming;
	

	public E27_Two(String ming) {
		super();
		this.ming = ming;
	}


	@Override
	public String toString() {
		return ming;
	}
}

public class E27_SerialObjectTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//序列化对象到文本
		FileOutputStream fis = new FileOutputStream(".\\Source\\18E27");
		ObjectOutputStream oos = new ObjectOutputStream(fis);
		oos.writeObject(new E27_One("xiao", "lian"));
		oos.close();
		
		//从文本中反序列化对象
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(".\\Source\\18E27"));
		E27_One one = (E27_One) ois.readObject();
		ois.close();
		System.out.println(one);
	}

}
