package pl.koziolekweb;

import java.util.Collection;
import java.util.Comparator;

/**
 * Hello world!
 */
public class App {
	static Silnia silnia = new Silnia();

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
}

interface Sort<T extends Comparable<T>>{

	Collection<T> sort(Collection<T> c);

	default <E> Collection<E> sort(Collection<E> c, Comparator<E> comp){
		throw new UnsupportedOperationException("Default impl");
	};
}

abstract class AbstractSort<T extends Comparable<T>>{

	abstract Collection<T> sort(Collection<T> c);

}

//interface FreeSort<E> extends Sort{
//
//	Collection<E> sort(Collection<E> c, Comparator<E> comp);
//
//}
//
//class A implements FreeSort<Object>{
//	@Override
//	public Collection<Object> sort(Collection<Object> c, Comparator<Object> comp) {
//		return null;
//	}
//
//	@Override
//	public Collection sort(Collection c) {
//		return null;
//	}
//}