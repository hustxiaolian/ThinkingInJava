package chapter15;

import java.util.ArrayList;
import java.util.List;

public class E27_CovariantAndGeneric {

	public static void main(String[] args) {
		//List<Number> nlst = new ArrayList<Integer>();//Type mismatch: cannot convert from ArrayList<Integer> to List<Number>
		//֤��Э��Է���������������
		
		//�������ʹ��ͨ��������ǿ�������������
		List<? extends Number> nlst = new ArrayList<Integer>();//������������ֻ֪�����nlist���ܳ���Number���������ͣ����Ǿ������;Ͳ�֪����
		//��ô�͵������޷���ȫ�Ĳ����κ����͡�
		//nlst.add(new Integer(0));
	}

}
