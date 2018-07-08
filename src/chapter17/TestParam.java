package chapter17;

public class TestParam {
	public final int size;
	public final int loop;
	
	public TestParam(int size, int loop) {
		super();
		this.size = size;
		this.loop = loop;
	}
	
	public static TestParam[] array(int...val) {
		int size = val.length / 2;
		TestParam[] result = new TestParam[size];
		int n = 0;
		for(int i = 0;i < size; ++i) {
			result[i] = new TestParam(val[n++], val[n++]);
		}
		return result;
	}
	
	public static TestParam[] array(String[] values) {
		int[] vals =  new int[values.length];
		for(int i = 0;i < vals.length; ++i) {
			vals[i] = Integer.decode(values[i]);
		}
		return array(vals);
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.decode(""));//Integer.decode()方法将字符串转换成为整型数字，可以识别
	}
}
