package chapter14;

import java.util.List;

public interface Robot {
	String name();
	String model();
	
	List<Operation> operation();
	static class Test {
		public static void test(Robot r) {
			if(r instanceof Null)//这里的Null时Null接口
			System.out.println("Robot Name: " + r.name());
			System.out.println("Robot model" + r.model());
			for(Operation r1 : r.operation()) {
				System.out.println(r1.decreption());
				r1.command();
			}
		}
	}
}
