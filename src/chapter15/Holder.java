package chapter15;

public class Holder<T> {
	private T value;

	/**
	 * @param value
	 */
	public Holder(T value) {
		super();
		this.value = value;
	}
	
	public Holder() {}
	
	/**
	 * 
	 * @return
	 */
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public boolean equals(Object ob) {
		return value.equals(ob);
	}
	
	public static void main(String[] args) {
		//这些都是正常操作
		Holder<Apple> Apple = new Holder<>(new Apple());
		Apple d = Apple.getValue();
		Apple.setValue(d);
		
		//下面是骚操作
		Holder<? extends Fruit> fruit = Apple;
		Fruit p = fruit.getValue();//让我想起了核心计数里面的一句话，extends只用get，super只能set，以后求证
		d = (chapter15.Apple) fruit.getValue();
		//Orange o = (Orange) fruit.getValue();//这里编译可以通过，但是它会ClassCastException,因为这个对象实际上就是Apple，不可能转型到Orange
		//当然所有的set方法都是不能用的
		//fruit.setValue(new Apple());
		//The method setValue(capture#4-of ? extends Fruit) in the type Holder<capture#4-of ? extends Fruit> is not applicable for the arguments (Apple)
		//而equal方法不受影响，因为它的参数都是Object，而且是调用Object内置定义的equal方法。
		System.out.println(fruit.equals(d));
	}
}
