package edu.vassar.jessica.number;
import java.io.*;
import java.util.*;

public class Number {

	// upper limit?

	public static String convert(int decimal) {

		// algorithm is to keep dividing by the base, (2) 
		// with the remainders creating the converted number from right to left
		int base = 2; 
		StringBuilder result = new StringBuilder();
		// decimal is the number are converting and what we start out with in calculation

		while (decimal > 0) {
			// Divide by the base to get quotient, use modulo to get remainder
			int q = decimal / base;
			int r = decimal % base;
			// Take remainder and add it on to number.
			// System.out.println("The remainder is " + r); // COMMENT OUT
			result.append(r);
			// Set decimal to the whole number quotient in the calculation
			decimal = q;
		}

		// reverse the appended string
		result.reverse();
		// System.out.println(result); 
		String binaryResult = result.toString();
		// System.out.println(binaryResult);
		return binaryResult;

	}

	public static void main(String[] args) {

		System.out.println(convert(10)); // Test
		// if () {
		// 	// file read
		// } else {
		// 	// std input read
		// }
		try {
			// // initialize FileReader, BufferedReader to read txt file
			BufferedReader theFile = new BufferedReader(new FileReader("SimpleBinaryConverter---TestInput.txt"));
			String line = theFile.readLine();
			
			while (line != null) {
				
				// convert string to number, call convert() method
				int lineAsNumber = Integer.parseInt(line); // ??? 
				System.out.println(convert(lineAsNumber));
				System.out.println("Read one line from txt file");
				line = theFile.readLine();
	        }
			theFile.close();
		} catch (IOException e) {
			System.out.println("IOException: " + e);

			//if no text file available, read from std input
			Scanner sc = new Scanner(System.in); 
			int i = sc.nextInt();
			System.out.println(convert(i));
			
		}
	}
}