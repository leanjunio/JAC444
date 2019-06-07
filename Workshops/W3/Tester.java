
/**
 * Tester
 */
import java.util.Scanner;
public class Tester {

  public static void main(String[] args) {
    
    boolean validInput = false;
    double real = 0, imaginary = 0;
    
    Scanner sc = new Scanner(System.in);
    
    do {
      System.out.print("Enter the first complex number: ");
      String line = sc.nextLine();
      validInput = Complex.validComplex(line);
    } while (!validInput);

    Complex first = new Complex(real, imaginary);

    do {
      System.out.print("Enter the second complex number: ");
      String line = sc.nextLine();
      validInput = Complex.validComplex(line);
    } while (!validInput);

    // Create the second complex number
    Complex second = new Complex(real, imaginary);

    calculate(first, second);
  }
  
  /**
   * Does the calculations for the passed complex numbers
   * @param first
   * @param second
   */
  public static void calculate(Complex first, Complex second) {
    System.out.println(first.toString() + " + " + second.toString() + " = " + first.add(second).toString());
    System.out.println(first.toString() + " - " + second.toString() + " = " + first.subtract(second).toString());
    System.out.println(first.toString() + " * " + second.toString() + " = " + first.multiply(second).toString());
    System.out.println(first.toString() + " / " + second.toString() + " = " + first.divide(second).toString());
    System.out.println("|" + first.toString() + "| = " + Complex.abs(first).toString());
  }
}
