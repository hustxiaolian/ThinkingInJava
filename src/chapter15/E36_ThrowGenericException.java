package chapter15;

import java.util.List;
import java.util.Set;

interface E36_Processor<T, E extends Exception, F extends Exception>{
	void process1(List<T> resultCollector) throws E;
	void process2(Set<T> resultSet) throws F;
}


class E36_Processor1 implements E36_Processor<String, Failure1, Failure2>{
	static int count = 3;
	@Override
	public void process1(List<String> resultCollector) throws Failure1 {
		if(count-- > 1)
			resultCollector.add("xiao,");
		else
			resultCollector.add("lian,");
		if(count < 0)
			throw new Failure1();
	}

	@Override
	public void process2(Set<String> resultSet) throws Failure2 {
		// TODO Auto-generated method stub
		if(count-- >= 0)
			resultSet.add(count + "");
		if(count < 0)
			throw new Failure2();
	}
	
}

public class E36_ThrowGenericException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
