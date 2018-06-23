package chapter15;

public class CreatorGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Creator c = new Creator();
		
	}

}

/**
 * 这就是模板
 * @author 25040
 * 将高层共性的东西放在一个抽象类中，然后独特的方法延迟到子类中去实现。
 * @param <T>
 */
abstract class GenericWithCreator<T>{
	private final T element;
	GenericWithCreator() {//模板
		element = create();
	}
	abstract T create();//独特方法
}

class Xiaolian{}

class Creator extends GenericWithCreator<Xiaolian>{

	@Override
	Xiaolian create() {
		return new Xiaolian();
	}
	
}
