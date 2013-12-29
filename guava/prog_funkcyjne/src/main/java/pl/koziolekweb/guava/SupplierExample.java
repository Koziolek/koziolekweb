package pl.koziolekweb.guava;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: koziolek
 * Date: 29.12.13
 * Time: 19:30
 * To change this template use File | Settings | File Templates.
 */
public class SupplierExample {

	public static void main(String[] args) {

		Timer timer = new Timer();
		Function<Long, String> dateLongToDateString = new Function<Long, String>() {

			@Override
			public String apply(Long input) {
				return input + ":" + (new Date(input)).toString();
			}
		};
		Supplier<String> compose = Suppliers
				.compose(dateLongToDateString, new SimpleCurrentDateAsLongSupplier());
//		timer.schedule(new SupplierTT(compose), 1000L, 1000L);

		System.out.println(Suppliers.supplierFunction().apply(compose));
	}
}

class SimpleCurrentDateAsLongSupplier implements Supplier<Long> {
	@Override
	public Long get() {
		Date d = new Date();
		return d.getTime();
	}
}

class SimpleCurrentDateAsStringSupplier implements Supplier<String> {
	@Override
	public String get() {
		Date d = new Date();
		return d.toString();
	}
}

class SupplierTT extends TimerTask {

	private final Supplier<?> supplier;

	SupplierTT(Supplier<?> supplier) {
		this.supplier = supplier;
	}

	@Override
	public void run() {
		System.out.println(supplier.get());
	}
}

