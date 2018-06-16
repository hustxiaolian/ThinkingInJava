package chapter10;

public class Demo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new E7().f2();
	}

}

class E7{
	private String s = "x";
	private void f() {
		System.out.println(s);
	}
	
	public void f2() {
		f();
		Inner i = new Inner();
		i.innerf();
		i.o = "oo";
		System.out.println(i.o);
	}
	
	class Inner{
		private String o = "o";
		void innerf() {
			s = "l";
			f();
		}
	}
	
	
}
