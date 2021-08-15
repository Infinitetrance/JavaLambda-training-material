package set5;

import java.util.function.UnaryOperator;

public class Recursive {
	/** step -2 , works but we can do better */
	UnaryOperator<Long> factorial;
	{
		factorial = i -> i == 0 ? 1 : i * factorial.apply(i - 1);
	}

	/** step -3.1 , this is more cleaner code */
	UnaryOperator<Long> factorialA3_1 = x -> x == 0 ? 1 : x * this.factorialA3_1.apply(x - 1);

	/** step -3.2 , this is more cleaner code, for static lambdas */
	static final UnaryOperator<Long> factorialA3_2 = x -> x == 0 ? 1 : x * Recursive.factorialA3_2.apply(x - 1);

	/**
	 * step -4 , recursion is possible with method reference too, but doesn't make
	 * any sense from usage perspective
	 */
	UnaryOperator<Long> factorialA3_3 = this.factorialA3_3::apply;

	public static void main(String[] args) {
		/** step -1 , not allowed by JLS */
		// UnaryOperator<Long> factorial = x -> x == 0 ? 1 : x * factorial.apply(x - 1);

		System.out.println(new Recursive().factorialA3_1.apply(3L));
		System.out.println(Recursive.factorialA3_2.apply(4L));
	}

}
