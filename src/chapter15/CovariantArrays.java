package chapter15;

public class CovariantArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fruit[] fruit = new Apple[10];//��ס����������ʱ����Fruit���飬����Fruit���飬���￴�Ƶ�����ת����Ϣֻ�����ڱ����ڡ�
		fruit[0] = new Apple();
		fruit[1] = new Jonathan();
		fruit[2] = new Fruit();//���������û���κξ���ʹ������������������ʱjvm�ͻ��׳�ArrayStoreException
		fruit[3] = new Orange();//����ͬ�ϡ�
		
		
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
