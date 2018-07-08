package chapter17;

public abstract class ContainerTest<C> {
	String name;

	public ContainerTest(String name) {
		super();
		this.name = name;
	}
	
	abstract int test(C container, TestParam tp);
}
