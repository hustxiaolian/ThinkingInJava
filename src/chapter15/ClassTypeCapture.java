package chapter15;

public class ClassTypeCapture<T> {
	Class<T> kind;

	ClassTypeCapture(Class<T> kind) {
		super();
		this.kind = kind;
	}
	
	public boolean f(Object obj) {
		return kind.isInstance(obj);
	}
	
	public static void main(String[] args) {
		ClassTypeCapture<Building> ctt1 = new ClassTypeCapture<>(Building.class);
		System.out.println(ctt1.f(new Building()));
		System.out.println(ctt1.f(new House()));
	}
}

class Building{}
class House extends Building{}
