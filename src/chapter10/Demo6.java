package chapter10;

/**
 * 
 * @author 25040
 * ����һ�¡��Ҷ�����һ���ӿڣ�Ȼ�����ڵ�һ�����ж�����һ��protected�ڲ���ʵ���˸ýӿڣ�������ʹ�÷�����
 * �ӿ��������ã���ʵ���ϵĶ���ȷʵ��һ���ඨ����ڲ�����󣬵�������ڲ�����ⲿ�ǲ��ɷ��ʵġ�
 * ���������ʵ�ֵ�ϸ�ڡ���
 */
public class Demo6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface Exercise6{
	void f();
}

class SimpleClass{
	protected class Inner implements Exercise6{
		public Inner() {
			
		}
		
		@Override
		public void f() {
			// TODO Auto-generated method stub
			
		}
		
	}
}

class SimpleClass2 extends SimpleClass{
	public Exercise6 get() {
		return new Inner();
	}
}