package set4;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class ChainingLambdas {

	public static void main(String[] args) {

		Consumer<String> step1 = s -> System.out.println("step1 consumes " + s);
		Consumer<String> step2 = s -> System.out.println("step2 consumes " + s);

		// Composition and chaining of Lambdas, Implementation approach 1, without
		// utilizing default methods/static methods
		System.out.println("stringProcessor: ");
		Consumer<String> stringProcessor = s -> {
			step1.accept(s);
			step2.accept(s);
		};
		stringProcessor.accept("Hello");

		// Composition and chaining of Lambdas, Implementation approach 2, through
		// default methods/static methods
		System.out.println("stringProcessor1: ");
		Consumer<String> stringProcessor1 = step1.andThen(step2);
		stringProcessor1.accept("Hello");

		System.out.println("isNull: ");
		Predicate<String> isNull = s -> s == null;
		System.out.println("For null = " + isNull.test(null));
		System.out.println("For Hello = " + isNull.test("Hello"));

		System.out.println("isEmpty: ");
		Predicate<String> isEmpty = s -> s.isEmpty();
		System.out.println("For empty = " + isEmpty.test(""));
		System.out.println("For Hello = " + isEmpty.test("Hello"));

		// Composition and chaining of Lambdas, Implementation approach 2, through
		// default methods/static methods
		System.out.println("isNotNullNotEmpty: ");
		Predicate<String> isNotNullNotEmpty = isNull.negate().and(isEmpty.negate());
		System.out.println("For null = " + isNotNullNotEmpty.test(null));
		System.out.println("For empty = " + isNotNullNotEmpty.test(""));
		System.out.println("For Hello = " + isNotNullNotEmpty.test("Hello"));
	}
}
