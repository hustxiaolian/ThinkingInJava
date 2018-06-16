package chapter14;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Shape> arr = new ArrayList<>(
				Arrays.asList(new Circle(), new Square(), new Triangle(), new Rhomboid()));
		for (Shape shape : arr) {
			System.out.println(shape);
		}
		/*
		Rhomboid r = (Rhomboid) arr.get(arr.size() - 1);
		Circle c = (Circle) arr.get(3);
		System.out.println(r);
		System.out.println(c);
		*/
		Rhomboid r = null;
		for (Shape shape : arr) {
			if(shape instanceof Rhomboid) {
				r = (Rhomboid) shape;
				System.out.println(r);
			}
		}
		
		for (Shape shape : arr) {
			if(!(shape instanceof Circle)) {
				shape.rotate(90);
			}
		}
	}
	
	

}

abstract class Shape{
	void draw() {
		System.out.println(this + ".draw()");
	}
	abstract public String toString();
	void rotate(int angle) {
		System.out.println(this + ".rotate:" + angle);
	}
}

class Circle extends Shape{

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Circle";
	}
	
}

class Square extends Shape{

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Square";
	}
	
}

class Triangle extends Shape{

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Triangle";
	}
	
}

class Rhomboid extends Shape{

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Rhomboid";
	}
	
}
