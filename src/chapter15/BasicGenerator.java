package chapter15;

public class BasicGenerator<T> implements Generator<T>{
	private Class<T> type;

	public BasicGenerator(Class<T> type) {
		super();
		this.type = type;
	}

	@Override
	public T next() {
		try {
			return type.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public static <T> Generator<T> create(Class<T> type) {
		return new BasicGenerator<>(type);
		
	}
	
}
