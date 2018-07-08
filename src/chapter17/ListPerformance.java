package chapter17;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListPerformance {
	static Random rand = new Random();
	static int reps = 1000;
	static List<ContainerTest<List<Integer>>> tests = new ArrayList<>();
	static List<ContainerTest<LinkedList<Integer>>> qtests = new ArrayList<>();
	
	static {
		tests.add(new ContainerTest<List<Integer>>("add") {
			
			@Override
			int test(List<Integer> container, TestParam tp) {
				int loops = tp.loop;
				int listsize = tp.size;
				for(int i = 0;i < loops; ++i) {
					container.clear();
					for(int j = 0;j < listsize;++j)
						container.add(j);
				}
				return loops * listsize;
			}
		});
		
		tests.add(new ContainerTest<List<Integer>>("get") {
			
			@Override
			int test(List<Integer> container, TestParam tp) {
				int loops = tp.loop;
				int listsize = tp.size;
				for(int i = 0;i < loops;++i) {
					container.get(rand.nextInt(listsize));
				}
				return loops;
			}
		});
	}
	
	static class ListTester extends ContainerTester<List<Integer>>{

		public ListTester(List<Integer> container, List<ContainerTest<List<Integer>>> tests) {
			super(container, tests);
		}
		
		@Override
		protected List<Integer> initialize(int size){
			container.clear();
			container.addAll(new CountingIntegerList(size));
			return container;
		}
		
		public static void run(List<Integer> list, List<ContainerTest<List<Integer>>> tests) {
			new ListTester(list, tests).timeTest();;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListTester.run(new ArrayList<>(), tests);
	}

}
