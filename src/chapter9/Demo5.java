package chapter9;

import test.Xiaolian;

public class Demo5 implements Xiaolian {

	public int age() {
		return 22;
	}

	public int run() {
		return 13;
	}

	public String school() {
		return "HUST MSE";
	}

	public static void main(String[] args) {
		Xiaolian xl = new Demo5();
		System.out.println(xl.age());
	}

}
