/**
 * Integers
 * 
 * a program that reads an integer between 0 and 1000 and adds all the digits in the
 * integer. For example, if an integer is 932, the sum of all its digits is 14
 */

import java.util.Scanner;   // Reading user input
public class Integers {

  public static void main(String[] args) {
    Scanner readObj = new Scanner(System.in);
    System.out.print("Enter a number between 0 and 1000: ");
    int number = readObj.nextInt();
    int total = 0;

    if (number >= 0 && number <= 1000) {
      readObj.close();

      String numberString = Integer.toString(number);
      char[] numberChars = numberString.toCharArray();
      
      for (char c : numberChars) {
        total += Character.getNumericValue(c);
      }

      System.out.print("Total of all the digits: " + total);
    }
  }
}