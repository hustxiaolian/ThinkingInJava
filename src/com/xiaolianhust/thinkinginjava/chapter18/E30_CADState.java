package com.xiaolianhust.thinkinginjava.chapter18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class Shape implements Serializable{
	public static final int RED = 1, BLUE = 2, GREEN = 3;
	private int xPos, yPos, dimension;
	private static Random rand = new Random();
	private static int counter = 0;
	
	public abstract void setColor(int newColor);
	public abstract int getColor();
	
	Shape(int xPos, int yPos, int dimension) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.dimension = dimension;
	}
	
	@Override
	public String toString() {
		return "Shape [xPos=" + xPos + ", yPos=" + yPos + ", dimension=" + dimension + "color" + getColor() + "]";
	}
	
	public static Shape randomFactory() {
		int x = rand.nextInt(100);
		int y = rand.nextInt(100);
		int z = rand.nextInt(100);
		switch(++counter % 3) {
		case 0:return new Circle(x, y, z);
		case 1:return new Square(x, y, z);
		case 2:return new Line(x, y, z);
		}
		return null;
	}
}

class Circle extends Shape {
	private static int color = RED;
	Circle(int xPos, int yPos, int dimension) {
		super(xPos, yPos, dimension);
	}
	@Override
	public void setColor(int newColor) {
		color = newColor;
	}
	@Override
	public int getColor() {
		return color;
	}
	public static void serializeStaticState(ObjectOutputStream os) throws IOException{
		os.writeInt(color);
	}
	public static void deserializeStaticState(ObjectInputStream is) throws IOException{
		color = is.readInt();
	}
}

class Square extends Shape{
	private static int color;
	Square(int xPos, int yPos, int dimension) {
		super(xPos, yPos, dimension);
		color = RED;
	}
	@Override
	public void setColor(int newColor) {
		color = newColor;
	}
	@Override
	public int getColor() {
		return color;
	}
	
	public static void serializeStaticState(ObjectOutputStream os) throws IOException{
		os.writeInt(color);
	}
	
	public static void deserializeStaticState(ObjectInputStream is) throws IOException{
		color = is.readInt();
	}
}

class Line extends Shape{
	private static int color;
	Line(int xPos, int yPos, int dimension) {
		super(xPos, yPos, dimension);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void setColor(int newColor) {
		color = newColor;
	}
	@Override
	public int getColor() {
		return color;
	}
	/**
	 * 手动序列化，因为Serializable接口不会自动序列化保存该数据
	 * @param os
	 * @throws IOException
	 */
	public static void serializeStaticState(ObjectOutputStream os) throws IOException{
		os.writeInt(color);
	}
	
	/**
	 * 手动反序列化恢复状态，
	 * @param is
	 * @throws IOException
	 */
	public static void deserializeStaticState(ObjectInputStream is) throws IOException{
		color = is.readInt();
	}
}


public class E30_CADState {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		List<Shape> shapes = new ArrayList<>();
		for(int i = 0;i < 10;++i) {
			shapes.add(Shape.randomFactory());
		}
		for(int i = 0;i < 10;++i) {
			shapes.get(i).setColor(Shape.GREEN);
		}
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(".\\Source\\18E30"));
		out.writeObject(shapes);
		Circle.serializeStaticState(out);
		Square.serializeStaticState(out);
		Line.serializeStaticState(out);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(".\\Source\\18E30"));
		shapes = (List<Shape>) in.readObject();
		Circle.deserializeStaticState(in);
		Square.deserializeStaticState(in);
		Line.deserializeStaticState(in);
		in.close();
		
		System.out.println(shapes);
	}

}
