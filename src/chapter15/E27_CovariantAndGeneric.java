package chapter15;

import java.util.ArrayList;
import java.util.List;

public class E27_CovariantAndGeneric {

	public static void main(String[] args) {
		//List<Number> nlst = new ArrayList<Integer>();//Type mismatch: cannot convert from ArrayList<Integer> to List<Number>
		//证明协变对泛型容器不起作用
		
		//如果我们使用通配符，倒是可以做到，但是
		List<? extends Number> nlst = new ArrayList<Integer>();//这样做编译期只知道这个nlist可能持有Number及其子类型，但是具体类型就不知道。
		//那么就导致了无法安全的插入任何类型。
		//nlst.add(new Integer(0));
	}

}
