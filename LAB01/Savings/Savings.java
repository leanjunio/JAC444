/**
 * Savings
 *  a program that prompts the user to enter a monthly saving amount and displays
 *  the account value after the sixth month. You are going to need to figure the monthly
 *  interest rate as well
 */
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;
public class Savings {

  public static void main(String[] args) {
    final double INTEREST_RATE = 5;
    final int MONTHS = 12;
    final double MONTHLY_INTEREST_RATE = (double)(INTEREST_RATE/MONTHS/100);
    double currentBalance = 0, enteredAmount = 0;
    Scanner readObj = new Scanner(System.in);
    System.out.print("Enter a monthly saving amount: ");
    
    enteredAmount = readObj.nextDouble();
    
    for (int i = 0; i < 6; i++) {
      currentBalance = (enteredAmount + currentBalance) * (1 + MONTHLY_INTEREST_RATE);  
    }

    BigDecimal bd = new BigDecimal(currentBalance);
    bd = bd.round(new MathContext(3));
    System.out.println("After 6 months amount: $" + bd.doubleValue());
  }
}