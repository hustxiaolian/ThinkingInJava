package chapter15;

public class TwoTuple<A,B> implements Comparable<TwoTuple<A, B>>{
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
	/*
	 * µÚÊ®ÆßÕÂE28
	 */
	public int hashCode() {
		int result = 17;
		if(first != null)
			result = result * 37 + first.hashCode();
		if(second != null)
			result = result * 37 + second.hashCode();
		return result;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof TwoTuple) {
			@SuppressWarnings("unchecked")
			TwoTuple<A, B> o = (TwoTuple<A, B>)obj;
			return (first == null ? o.first == null : first.equals(o.first)) &&
					(second == null ? o.second == null : second.equals(o.second));
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}



	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(TwoTuple<A, B> arg0) {
		int res = ((Comparable<A>)first).compareTo(arg0.first);
		if(res != 0) return res;
		return ((Comparable<B>)second).compareTo(arg0.second);
	}

}
