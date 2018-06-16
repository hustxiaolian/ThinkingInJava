package chapter8;

/**
 * 
 * @author 25040
 *
 */
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cycle[] c = new Cycle[] {
				new Unicycle(),
				new Bicycle(),
				new Tricycle()
		};
		for (Cycle cycle : c) {
			cycle.balance();
		}
		((Unicycle)c[0]).balance();
		((Bicycle)c[1]).balance();
		((Tricycle)c[2]).balance();
	}

}

class Cycle{
	public void ride() {
		System.out.println("Cycle ride");
	}
	public void balance() {
		System.out.println("Cycle balance");
	}
}

class Unicycle extends Cycle{
	public void ride() {
		System.out.println("UniCycle ride");
	}
	public void balance() {
		System.out.println("Unicycle balance");
	}
}

class Bicycle extends Cycle{
	public void ride() {
		System.out.println("BiCycle ride");
	}
	public void balance() {
		System.out.println("Bicycle balance");
	}
}

class Tricycle extends Cycle{
	public void ride() {
		System.out.println("TriCycle ride");
	}
}
