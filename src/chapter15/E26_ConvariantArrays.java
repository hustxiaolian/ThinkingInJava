package chapter15;

public class E26_ConvariantArrays {
	public static void main(String[] args) {
		Number[] nums = new Integer[10];
		nums[0] = 1;//记住它只是看起来向上转型了，它实际上还是Integer数组
		nums[1] = 0.0f;//报错，但是编译期可以通过。
	}
}
