package chapter15;

public class CovariantArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fruit[] fruit = new Apple[10];//记住这里在运行时就是Fruit数组，不是Fruit数组，这里看似的向上转型信息只发生在编译期。
		fruit[0] = new Apple();
		fruit[1] = new Jonathan();
		fruit[2] = new Fruit();//这里编译期没有任何警告和错误产生，但是在运行时jvm就会抛出ArrayStoreException
		fruit[3] = new Orange();//这里同上。
		
		
	}
	
	
}


class Fruit{

	@Override
	public String toString() {
		return "Fruit []";
	}
	
}
class Apple extends Fruit{

	@Override
	public String toString() {
		return "Apple []";
	}
	
}
class Jonathan extends Apple{}
class Orange extends Fruit{}
