package chapter10;

public class Demo13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
interface E13face{
	void e13f();
}

class E13SimpleClss{
	E13face getInner() {//这么看来内部类是很方便，可以根据需要直接返回定制的接口实现对象和基类扩展对象
		return new E13face() {
			@Override
			public void e13f() {
				// TODO Auto-generated method stub
				System.out.println("E13f");
			}
		};
	}
}


