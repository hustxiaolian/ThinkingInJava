package chapter14;

public class Person {
	public final String first;
	public final String last;
	public final String address;
	
	public Person(String first, String last, String address) {
		super();
		this.first = first;
		this.last = last;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person [first=" + first + ", last=" + last + ", address=" + address + "]";
	}
	
	public static final Person NULL = new NullPerson();
	
	public static class NullPerson extends Person implements Null{

		public NullPerson() {
			super("Node", "Node", "Node");
		}
		
		public String toString() {
			return "NullPerson";
		}
		
	}
	
}

interface Null{
	
}
