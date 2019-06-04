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

    // Create the first complex number
    Complex second = new Complex(real, imaginary);
  }
}