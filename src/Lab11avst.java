/*************************************
 * Brendan Shine 
 * Mr. Kiedes Period 2               *
 * 11-23-15             
 * Sieve of Eratosthenes Program
 *                                   *
 ************************************/

// Lab11avst.java
// The "Sieve of Eratosthenes" Program
// This is the student, starting version of the Lab11a assignment.

import java.util.Scanner;
import java.text.DecimalFormat;

public class Lab11avst {
	public static void main(String[] args) {
		// This main method needs additions for the 100 point version.
		Scanner input = new Scanner(System.in);
		final int MAX = input.nextInt() + 1; // user imput of range of numbers
												// starting with 1
		boolean primes[];
		primes = new boolean[MAX];
		System.out.println("\n\nPRIMES BETWEEN 1 AND " + (MAX - 1) + "\n");
		computePrimes(primes);
		displayPrimes(primes);
	}

	public static void computePrimes(boolean primes[]) // finds the prime
														// numbers
	{
		// 0 and 1 will always be false
		primes[0] = false;
		primes[1] = false;

		for (int i = 2; i <= primes.length - 1; i++) {
			// everything starts out as prime
			primes[i] = true;
		}
		// Checks every number above 2 for being prime or not
		for (int k = 2; k < primes.length; k++) {
			if (primes[k] == true) {
				for (int i = k * k; i < primes.length; i += k) {
					primes[i] = false;
				}
			}
		}
	}

	public static void displayPrimes(boolean primes[])
	// displays each of the prime numbers
	{
		DecimalFormat output = new DecimalFormat("0000");
		// Used to have line feed every 16 entries
		int wrapText = 0;
		for (int k = 2; k < primes.length; k++) {
			if (primes[k] == true) {
				System.out.print(output.format(k) + " ");
				wrapText++;
				// Line feed every 16 entries for wrapping text in output
				if (wrapText % 16 == 0)
					System.out.println();

			}
		}
	}

}
