package chapter17;

import java.util.ArrayList;
import java.util.Collections;

class StringAddress{
	private String s;

	public StringAddress(String s) {
		super();
		this.s = s;
	}
	
	public String toString(){
		return super.toString() + " " + s;
	}
	
}

public class FillingLists {
	public static void main(String[] args) {
		ArrayList<StringAddress> list = new ArrayList<>(Collections.nCopies(4, new StringAddress("HELLO")));
		System.out.println(list);//ע�⵽���ɵ��ĸ�������ڴ��ַ��һ���ģ�Ҳ����˵4������ָ��ͬһ����
		Collections.fill(list, new StringAddress("world"));
		System.out.println(list);
	}
}
