package chapter15;

import java.awt.Color;

public class BasicBounds {

}

interface HasColor{
	java.awt.Color getColor();
}

class Colored<T extends HasColor> {
	T item;

	Colored(T item) {
		super();
		this.item = item;
	}

	public T getItem() {
		return item;
	}
	
	java.awt.Color color() {
		return item.getColor();
	}
}

class Demension{
	public int x,y,z;
}

class ColoredDimension<T extends Demension & HasColor>{
	T item;

	ColoredDimension(T item) {
		super();
		this.item = item;
	}

	public T getItem() {
		return item;
	}
	
	java.awt.Color color() {
		return item.getColor();
	}
	
	int getX() {
		return item.x;
	}
	
	int getY() {
		return item.y;
	}
	
	int getZ() {
		return item.z;
	}
}

interface Weight{
	int weight();
}

class Solid<T extends Demension & HasColor & Weight>{
	T item;

	Solid(T item) {
		super();
		this.item = item;
	}

	public T getItem() {
		return item;
	}
	
	java.awt.Color color() {
		return item.getColor();
	}
	
	int getX() {
		return item.x;
	}
	
	int getY() {
		return item.y;
	}
	
	int getZ() {
		return item.z;
	}
	
	int weight() {
		return item.weight();
	}
}

class Bounded extends Demension implements HasColor, Weight{

	@Override
	public int weight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}
	
}