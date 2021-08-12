package set1;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FirstLambdas {

	public static void main(String[] args) {

		// Supplier
		// Implementation Syntax style 1, Verbose
		Supplier<String> supplier = () -> {
			return "Hello!";
		};

		// Implementation Syntax style 2, minimal verbose
		supplier = () -> "Hello!";

		String string = supplier.get();
		System.out.println("string = " + string);

		// Consumer
		// Implementation Syntax style 1, Verbose
		Consumer<String> consumer = (String s) -> {
			System.out.println(s);
		};

		// Implementation Syntax style 2, minimal verbose
		consumer = s -> System.out.println(s);

		consumer.accept("Hello");

	}

}
