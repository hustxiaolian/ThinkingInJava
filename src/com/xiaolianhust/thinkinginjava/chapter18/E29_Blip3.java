package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class E29_Blip3 implements Externalizable {
	private String s;
	private int i;
	
	public E29_Blip3() {
		// TODO Auto-generated constructor stub
	}
	
	public E29_Blip3(String s, int i) {
		super();
		this.s = s;
		this.i = i;
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("readExternal");
//		s = (String) in.readObject();//
//		i = in.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("WriteExternal");
		out.writeObject(s);
		out.writeInt(i);
	}
	
	
	@Override
	public String toString() {
		return "E29_Blip3 [s=" + s + ", i=" + i + "]";
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		E29_Blip3 b3 = new E29_Blip3("xiaolian", 2018);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(".\\Source\\18E29"));
		out.writeObject(b3);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(".\\Source\\18E29"));
		b3 = (E29_Blip3) in.readObject();
		System.out.println(b3);
	}
}
