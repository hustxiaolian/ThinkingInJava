package chapter15;

class GeneriClass1<T>{
	T x;
}

class GenericClass2<T> extends GeneriClass1<T> {}
class GenericClass3<T,E> extends GeneriClass1<E> {}
class GenericClass4<T,E> extends GeneriClass1<T> {}

class GenericClass5 extends GeneriClass1<Integer> {}

class GenericClass0<T,E> {
	T x;
	E y;
}

class GenericClass6<T,E> extends GenericClass0<T,E> {}
class GenericClass7<T> extends GenericClass0<T,Integer> {}
class GenericClass8<E> extends GenericClass0<Integer,E> {}
class GenericClass9 extends GenericClass0<String,Integer> {}
class GenericClass10<T> extends GenericClass0<T,T> {}

public class GenericExtendTest {
	
}
