package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class House implements Serializable {}

class Animal implements Serializable {
	private String name;
	private House preferedHouse;
	
	Animal(String name, House preferedHouse) {
		super();
		this.name = name;
		this.preferedHouse = preferedHouse;
	}

	@Override
	public String toString() {
		return name + "[" + super.toString() + "]," + preferedHouse + "\n";
	}
}




public class MyWorld {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		House house = new House();
		List<Animal> animals = new ArrayList<>();
		animals.add(new Animal("dog", house));
		animals.add(new Animal("cat", house));
		animals.add(new Animal("mouse", house));
		
		ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
		ObjectOutputStream out1 = new ObjectOutputStream(buf1);
		out1.writeObject(animals);
		out1.writeObject(animals);//同一个流对象，写入两次，系统知道它们两者相同，因此后续还原的时候，它们的地址也会一样
		out1.close();
		
		ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
		ObjectOutputStream out2 = new ObjectOutputStream(buf2);
		out2.writeObject(animals);
		out2.close();//不同的流对象再次写入数据，恢复后，由于系统不知道它们两者时一样的，因此会生成不同的对象，尽管它们的内容是一样的额
		
		ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
		ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
		List animals1 = (List) in1.readObject();
		List animals2 = (List) in1.readObject();
		List animals3 = (List) in2.readObject();
		System.out.println("animals1: " + animals1);
		System.out.println("animals2: " + animals2);
		System.out.println("animals3: " + animals3);
		in1.close();
		in2.close();
	}

}
