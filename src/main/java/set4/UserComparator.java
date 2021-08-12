package set4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class UserComparator {

	public static void main(String[] args) {

		User sarah = new User("Sarah", 28);
		User james = new User("James", 35);
		User mary = new User("Mary", 33);
		User john1 = new User("John", 24);
		User john2 = new User("John", 25);

		List<User> users = Arrays.asList(sarah, james, mary, john1, john2);

		Comparator<User> cmpName = Comparator.comparing(user -> user.getName());

		System.out.println("what are we doing wrong here(at cmpAge) ?");
		System.out.println(unscramble(
				"W-ll, w- 1*- u+6ng In^-g-* ^yp- -x^*1c^o*(1^ comp1*6ng m-^hod'+ 1*gum-n^) h-*- 6n+^-1d of p*6m6^6v- 6n^ ^yp- 1nd ^h6+ w6ll co+^ ov-*h-1d of 1u^o(un)box6ng\r\n"));
		Comparator<User> cmpAge = Comparator.comparing(user -> user.getAge());

		Comparator<User> comparator = cmpName.thenComparing(cmpAge);
		Comparator<User> reversed = comparator.reversed();

		users.sort(reversed);
		users.forEach(u -> System.out.println(u));
	}

	static String unscramble(String s) {
		return s.replace('1', 'a').replace('6', 'i').replace('+', 's').replace('-', 'e').replace('*', 'r').replace('^',
				't');
	}

	static String scramble(String s) {
		return s.replace('a', '1').replace('i', '6').replace('s', '+').replace('e', '-').replace('r', '*').replace('t',
				'^');
	}
}
