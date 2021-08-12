package set1;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FirstLambdasTemp {

	public static void main(String[] args) {

		// Supplier
		// Implementation Syntax style 1, Verbose
		Supplier<String> supplier = null;

		// Implementation Syntax style 2, minimal verbose
		supplier = () -> null;

		String string = supplier.get();
		System.out.println("string = " + string);

		// Consumer
		// Implementation Syntax style 1, Verbose
		Consumer<String> consumer = null;

		// Implementation Syntax style 2, minimal verbose
		consumer = null;

		consumer.accept("Hello");

	}

}
