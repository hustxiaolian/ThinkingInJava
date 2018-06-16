package chapter8;

public class Demo13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shared s = new Shared();
		Composing[] c = new Composing[] {
			new Composing(s),new Composing(s),new Composing(s),new Composing(s),new Composing(s),
		};
		for (Composing composing : c) {
			composing.dispose();
		}
		System.gc();
		new Composing(new Shared());
		System.gc();
	}
	
	
}

class Shared {
	private static long idcounter = 0;
	private final long id = ++idcounter;
	private int refCounter = 0;
	
	public Shared() {
		System.out.println("Create" + this);
	}
	public void addRef() {
		refCounter++;
	}
	public void disposed() {
		if(--refCounter == 0) {
			System.out.println("Dispose" + this);
		}
	}
	
	protected void finalize() {
		if(refCounter != 0)
			System.out.println("Error");
	}
	public String toString(){
		return ("Shared" + id);
	}
}

class Composing{
	private Shared sh;
	private static long idcounter = 0;
	private final long id = ++idcounter;
	public Composing(Shared shared) {
		sh = shared;
		System.out.println("Creating" + this);
		shared.addRef();
	}
	
	public void dispose() {
		System.out.println("dispose " + this);
		sh.disposed();
	}
	
	public String toString() {
		return "Composing" + id;
	}
}
