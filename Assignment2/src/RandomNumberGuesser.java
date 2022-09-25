/*
 * Class: CMSC203 
 * Instructor: David Kujit
 * Description: (Give a brief description for each Class)
 * Due: 9/25/2022
 * Platform/compiler: Javac
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Justin Nguyen
*/

import java.util.Scanner;

public class RandomNumberGuesser {
	public static void main(String[] args) {
		// declare constant values used in program
		final int MAX_GUESSES = 7;
		final String DESCRIPTION = "This application generates a random integar between 0 and 100 and\nasks the user to guess repeatedly until they guess correctly.\n";
		final String PROGRAMMER_NAME = "Programmer Name: Justin Nguyen";

		System.out.println(DESCRIPTION);
		Scanner scan = new Scanner(System.in);
		boolean repeat = true;

		// loops program when the user says they want to play again
		while (repeat) {
			int highGuess = 100;
			int lowGuess = 0;
			int answer = RNG.rand();
			int guess = 0;
			System.out.print("Enter your first guess: ");
			// checks the user's guess and provides feedback while they still have guesses
			while (RNG.getCount() <= MAX_GUESSES) {
				guess = scan.nextInt();
				while (!RNG.inputValidation(guess, lowGuess, highGuess)) {
					guess = scan.nextInt();
				}
				if (guess == answer && RNG.getCount() != 8) {
					System.out.println("Congratulations, you guessed the number!");
					break;
				} else if (guess < answer && RNG.getCount() != 8) {
					System.out.println("Your guess it too low");
					System.out.println("Number of guesses: " + RNG.getCount());
					lowGuess = guess;
					System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
				} else if (guess > answer && RNG.getCount() != 8) {
					System.out.println("Your guess it too high");
					System.out.println("Number of guesses: " + RNG.getCount());
					highGuess = guess;
					System.out.println("Enter your next guess between " + lowGuess + " and " + highGuess);
				}
			}

			if (guess != answer) {
				System.out.println("You have exceeded the maximum number of guesses, 7.");
			}
			System.out.print("Would you like to play again (yes or no)?");

			// asks if user wants to play again, and if user provides invalid response, it
			// will loop until they provide a valid response
			boolean invalid = true;
			scan.nextLine();
			while (invalid) {
				String choice = scan.nextLine();
				if (choice.equalsIgnoreCase("yes")) {
					invalid = false;
					repeat = true;
					RNG.resetCount();
				} else if (choice.equalsIgnoreCase("no")) {
					System.out.print("\nThank you for playing\n" + PROGRAMMER_NAME);
				} else {
					System.out.println("That is not a valid option. Please enter yes or no");
					invalid = true;
				}
			}
		}
		scan.close();
	}
}