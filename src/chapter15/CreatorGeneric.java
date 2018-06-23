package chapter15;

public class CreatorGeneric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Creator c = new Creator();
		
	}

}

/**
 * �����ģ��
 * @author 25040
 * ���߲㹲�ԵĶ�������һ���������У�Ȼ����صķ����ӳٵ�������ȥʵ�֡�
 * @param <T>
 */
abstract class GenericWithCreator<T>{
	private final T element;
	GenericWithCreator() {//ģ��
		element = create();
	}
	abstract T create();//���ط���
}

class Xiaolian{}

class Creator extends GenericWithCreator<Xiaolian>{

	@Override
	Xiaolian create() {
		return new Xiaolian();
	}
	
}
