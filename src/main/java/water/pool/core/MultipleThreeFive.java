package water.pool.core;

public class MultipleThreeFive {

	private static final int MAX = 101;

	public static void main(String[] args) {
		printReplace(0);
	}

	public static void printReplace(int i) {
		i++;
		if (i < MAX) {
			compute(i);
			printReplace(i);
		}
	}

	public static void compute(int c) {
		String result = "";
		if ((c % 3 == 0) && (c % 5 == 0)) {
			result = "FizzBuzz";
		} else if (c % 5 == 0) {
			result = "Fizz";
		} else if (c % 3 == 0) {
			result = "Buzz";
		} else {
			result = String.valueOf(c);
		}
		System.out.println(result);
	}

}
