package chapter10;

public class Demo12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new E12().getInner();
	}

}

class E12{
	private String s = "xiaolian";
	private void f() {
		System.out.println(s);
	}
	
	void getInner() {
		new Object() {
			void modify() {
				f();
				s = "lianxiao";
				f();
			}
		}.modify();
	}
}
