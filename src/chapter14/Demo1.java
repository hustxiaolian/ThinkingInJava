package chapter14;

public class Demo1 {
	
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class c = null;
		ToyTest t = new ToyTest();
		try {
			c = Class.forName("chapter14.FancyToy");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t.printInfo(c);
		for(Class face : c.getInterfaces()) {
			t.printInfo(face);
		}
		Class up = c.getSuperclass();
		Object obj = null;
		try {
			obj = up.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		t.printInfo(obj.getClass());
	}
}

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}
interface xiaolian{}

class Toy{
	Toy() {}
	Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries, Waterproof, Shoots, xiaolian{
	public FancyToy() {
		// TODO Auto-generated constructor stub
		super(1);
	}
}

class ToyTest{
	@SuppressWarnings("rawtypes")
	public void printInfo(Class cc) {
		System.out.printf("Class name:%s is interface? [%b]\n", cc.getName(), cc.isInterface());
		System.out.printf("Simple name:%s\n", cc.getSimpleName());
		System.out.printf(String.format("Cononcial name:%s\n" ,cc.getCanonicalName()));
	}
}
