import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		OutOfBounds checker = new OutOfBounds(-3, 28);
		
		// Expressions inside assert statements should
		//  be true if the code is correct
		alwaysAssert(checker.tooHigh() == 0);
		alwaysAssert(checker.tooLow() == 0);
		
		checker.process(-3);
		alwaysAssert(checker.tooHigh() == 0);
		alwaysAssert(checker.tooLow() == 0);
		
		checker.process(29);
		alwaysAssert(checker.tooHigh() == 1);
		alwaysAssert(checker.tooLow() == 0);
		
		checker.process(-4);
		alwaysAssert(checker.tooHigh() == 1);
		alwaysAssert(checker.tooLow() == 1);
		
		checker.process(-4382);
		alwaysAssert(checker.tooHigh() == 1);
		alwaysAssert(checker.tooLow() == 2);
		
		checker.process(-4382);
		alwaysAssert(checker.tooHigh() == 1);
		alwaysAssert(checker.tooLow() == 3);
		
		checker.process(15);
		alwaysAssert(checker.tooHigh() == 1);
		alwaysAssert(checker.tooLow() == 3);
		
		ArrayList<Integer> numbers = new ArrayList<>();
		numbers.add(29);
		numbers.add(12);
		numbers.add(-15);
		numbers.add(29);
		
		checker.process(numbers);
		alwaysAssert(checker.tooHigh() == 3);
		alwaysAssert(checker.tooLow() == 4);
		
		System.out.println("Passed tests");
		
	}

	// simple custom assertion check that doesn't need to be enabled to work
	private static void alwaysAssert(boolean check) {
		if (!check) {
			throw new AssertionError();
		}
	}
}
