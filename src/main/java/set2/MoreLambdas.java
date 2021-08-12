package set2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MoreLambdas {

	public static void main(String[] args) {

		List<String> strings = new ArrayList<>(List.of("one", "two", "three", "four", "five"));

		// Local target variable syntax style, verbose
		
		Predicate<String> startsWithT = string -> !string.startsWith("t");
		strings.removeIf(startsWithT);

		Consumer<String> sysout = string -> System.out.println(string);
		strings.forEach(sysout);

		// Inline syntax style, less verbose 
		strings.removeIf(string -> !string.startsWith("t")); // Predicate usage

		strings.forEach(string -> System.out.println(string)); // Consumer usage
	}
}
