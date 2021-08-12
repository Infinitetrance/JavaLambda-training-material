package set4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class CreatingCompartors {

	public static void main(String[] args) {

		List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

		// Sort in lexicographical order
		Comparator<String> cmp0 = (s1, s2) -> s1.compareTo(s2);
		strings.sort(cmp0);
		System.out.println(strings);

		// Sort on basis of string length
		Comparator<String> cmp1 = (s1, s2) -> Integer.compare(s1.length(), s2.length());
		strings.sort(cmp1);
		// System.out.println(strings);

		// using extractor to separate logic of sorting from logic of object
		// mapping/transformation
		Function<String, Integer> lengthExtractor = (string) -> string.length();
		Comparator<String> cmp2 = Comparator.comparing(lengthExtractor);
		strings.sort(cmp2);
		// System.out.println(strings);

		// using primitive int function(for extractor impl) to avoid overhead of
		// auto(un)boxing
		ToIntFunction<String> toLength = s -> s.length();
		Comparator<String> cmp3 = Comparator.comparingInt(toLength);
		strings.sort(cmp3);
		System.out.println(strings);
	}
}
