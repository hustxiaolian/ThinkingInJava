package chapter10;

public class Demo13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
interface E13face{
	void e13f();
}

class E13SimpleClss{
	E13face getInner() {//��ô�����ڲ����Ǻܷ��㣬���Ը�����Ҫֱ�ӷ��ض��ƵĽӿ�ʵ�ֶ���ͻ�����չ����
		return new E13face() {
			@Override
			public void e13f() {
				// TODO Auto-generated method stub
				System.out.println("E13f");
			}
		};
	}
}


