package chapter10;

public class Demo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Outer2 o = new Outer2();
		Outer2.Inner i = o.new Inner();
	}

}

class Outer2{
	class Inner{}
}
