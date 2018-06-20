package chapter15;

public class TwoTuple<A, B> {
	public final A first;
	public final B second;
	
	@Override
	public String toString() {
		return "TwoTuple [first=" + first + ", second=" + second + "]";
	}



	public TwoTuple(A first, B second) {
		super();
		this.first = first;
		this.second = second;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
