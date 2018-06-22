package chapter15;

public class E14_BasicGenericGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Generator<Coffee> gen = new BasicGenerator<>(Coffee.class);
		System.out.println(gen.next());
	}
}
