package set5;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

import set4.User;

public class CreatingCompartors {

	public static void main(String[] args) {

		/**
		 * Method Reference Kind: Reference to a static method
		 */

		// Implementation approach 1, without method references
		Function<String, Integer> strToInt0 = str -> Integer.parseInt(str);

		// Implementation approach 2, through method references
		Function<String, Integer> strToInt1 = Integer::parseInt;
		System.out.println("strToInt1: " + strToInt1.apply("123"));

		/**
		 * Method Reference Kind: Reference to an instance method of a particular object
		 */
		User sarah = new User("Sarah", 28);
		User james = new User("James", 35);
		User mary = new User("Mary", 33);
		User john1 = new User("John", 24);
		User john2 = new User("John", 25);

		List<User> users = Arrays.asList(sarah, james, mary, john1, john2, sarah);

		// Implementation approach 1, without method references
		users.forEach(u -> System.out.println(u));
		System.out.println();
		// Implementation approach 2, through method references
		users.forEach(System.out::println);

		/**
		 * Method Reference Kind: Reference to an instance method of an arbitrary object
		 * of a particular type
		 */

		List<String> strings = Arrays.asList("one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

		// Implementation approach 1, without method references
		// Sort in lexicographical order
		Comparator<String> cmp0 = (s1, s2) -> s1.compareTo(s2);

		// Implementation approach 2, through method references
		// Sort in lexicographical order
		Comparator<String> cmp1 = String::compareTo;

		strings.sort(cmp1);
		System.out.println(strings);

		/**
		 * Method Reference Kind: Reference to a constructor
		 */

		// Implementation approach 1, without method references
		Set<User> userSet = transferElements(users, () -> new HashSet<>());

		// Implementation approach 2, through method references
		userSet = transferElements(users, HashSet::new);
		System.out.println("userSet: " + userSet);

	}

	public static <T, SOURCE extends Collection<T>, DEST extends Collection<T>> DEST transferElements(
			SOURCE sourceCollection, Supplier<DEST> collectionFactory) {

		DEST result = collectionFactory.get();
		for (T t : sourceCollection) {
			result.add(t);
		}
		return result;
	}
}
