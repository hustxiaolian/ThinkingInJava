package chapter15;

public class GenericAndReturnType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f(new GetterTest());
	}
	
	static void f(Getter g) {
		Getter result = g.get();
		
	}

}

interface GenericGetter<T extends GenericGetter<T>>{//����ӿڣ�����ӿ�ò��û��ֱ���ã������þ���Ľӿ����ͼ̳��¡�
	T get();
}

interface Getter extends GenericGetter<Getter> {}//�������޶�����ӿڣ������get��������������T���Getter���ͣ��޶��ھ���Ľӿ�����

class GetterTest implements Getter{

	@Override
	public Getter get() {
		// TODO Auto-generated method stub
		return null;
	}
	
}