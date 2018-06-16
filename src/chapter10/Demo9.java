package chapter10;

public class Demo9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface E9face{
	void e9f1();
	void e9f2();
}

class E9SimpleClass{
	private class Inner implements E9face{

		@Override
		public void e9f1() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void e9f2() {
			// TODO Auto-generated method stub
			
		}
	}
	
	E9face get() {
		class Inner2 implements E9face{

			@Override
			public void e9f1() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void e9f2() {
				// TODO Auto-generated method stub
				
			}
			
		}
		return new Inner2();
	}
}
