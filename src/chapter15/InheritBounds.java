package chapter15;

import java.awt.Dimension;

public class InheritBounds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class HoldItem<T>{
	T item;

	HoldItem(T item) {
		super();
		this.item = item;
	}

	public T getItem() {
		return item;
	}
}

class Colored2<T extends HasColor> extends HoldItem<T>{

	Colored2(T item) {
		super(item);
	}
	
	java.awt.Color color() {
		return item.getColor();
	}
}

class ColoredDimension2<T extends Demension & HasColor> extends Colored2<T>{

	ColoredDimension2(T item) {
		super(item);
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

class Solid23<T extends Demension & HasColor & Weight> extends ColoredDimension2<T>{

	Solid23(T item) {
		super(item);
	}
	
	int weight() {
		return item.weight();
	}
	
}
