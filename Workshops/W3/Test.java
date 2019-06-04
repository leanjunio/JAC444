/**
 * Test
 */
import java.util.Scanner;
public class Test {

  public static void main(String[] args) {
    System.out.print("Enter the first complex number: ");

    Scanner sc = new Scanner(System.in);

    double real = sc.nextDouble();
    double imaginary = sc.nextDouble();

    Complex first = new Complex(real, imaginary);

    System.out.print("Enter the second complex number: ");

    real = sc.nextDouble();
    imaginary = sc.nextDouble();

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