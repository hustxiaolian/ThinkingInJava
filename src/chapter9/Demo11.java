package chapter9;

public class Demo11 {

	public static void main(String[] args) {
		
		Apply1.process(new StringConcaterAdapter(new StringConcater()), "Hust");
	}
	
	
}

interface Processor{
	String name();
	Object process(Object input);
}

class Apply1{
	public static void process(Processor p, Object s) {
		System.out.println("Using process " + p.name());
		p.process(s);
	}
}

class StringConcater{
	public String doit(String s) {
		return s.concat("xiaolian");
	}
}

class StringConcaterAdapter implements Processor{
	private StringConcater s;
	public StringConcaterAdapter(StringConcater con) {
		s = con;
	}
	@Override
	public String name() {
		return getClass().getSimpleName();
	}
	@Override
	public String process(Object input) {
		return s.doit((String)input);
	}
	
}