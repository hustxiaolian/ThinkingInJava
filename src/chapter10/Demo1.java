package chapter10;

public class Demo1 {

	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner i = o.getInner();//������ͨ�ڲ������ñ��벹���ⲿ��·��
		System.out.println(i);
	}

}

class Outer{
	private String s = "xiaolian";
	class Inner{
		@Override
		public String toString() {
			return s;
		}
	}
	public Inner getInner() {
		return new Inner();
	}
	
	
}
