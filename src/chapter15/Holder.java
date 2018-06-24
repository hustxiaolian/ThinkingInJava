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
		//��Щ������������
		Holder<Apple> Apple = new Holder<>(new Apple());
		Apple d = Apple.getValue();
		Apple.setValue(d);
		
		//������ɧ����
		Holder<? extends Fruit> fruit = Apple;
		Fruit p = fruit.getValue();//���������˺��ļ��������һ�仰��extendsֻ��get��superֻ��set���Ժ���֤
		d = (chapter15.Apple) fruit.getValue();
		//Orange o = (Orange) fruit.getValue();//����������ͨ������������ClassCastException,��Ϊ�������ʵ���Ͼ���Apple��������ת�͵�Orange
		//��Ȼ���е�set�������ǲ����õ�
		//fruit.setValue(new Apple());
		//The method setValue(capture#4-of ? extends Fruit) in the type Holder<capture#4-of ? extends Fruit> is not applicable for the arguments (Apple)
		//��equal��������Ӱ�죬��Ϊ���Ĳ�������Object�������ǵ���Object���ö����equal������
		System.out.println(fruit.equals(d));
	}
}
