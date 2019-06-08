/**
 * Tester
 */
import java.util.Scanner;
import java.util.StringTokenizer;
public class Tester {

  public static void main(String[] args) {
    StringBuffer l = new StringBuffer("");
    boolean validInput = false;
    double real = 0, imaginary = 0;
    
    Scanner sc = new Scanner(System.in);
    
    // Asks for first complex number including validation
    do {
      System.out.print("Enter the first complex number: ");
      String line = sc.nextLine();
      l.delete(0, l.length());
      l.replace(0, line.length(), line);
      validInput = Complex.validComplex(line);
    } while (!validInput);
    
    StringTokenizer s = new StringTokenizer(l.toString());
    real = Double.parseDouble(s.nextToken());
    imaginary = Double.parseDouble(s.nextToken());
    Complex first = new Complex(real, imaginary);
    
    // Asks for second complex number including validation
    do {
      System.out.print("Enter the second complex number: ");
      String line = sc.nextLine();
      l.delete(0, l.length());                  // clear the contents of StringBuffer 'l'
      l.replace(0, line.length(), line);        // replace the contents of 'l' with the line
      validInput = Complex.validComplex(line);  // validation
    } while (!validInput);

    // gets the two numbers that are in the string
    StringTokenizer ss = new StringTokenizer(l.toString());
    real = Double.parseDouble(ss.nextToken());
    imaginary = Double.parseDouble(ss.nextToken());
    Complex second = new Complex(real, imaginary);

    // calls the calculate function which runs the proper operations in their proper order
    calculate(first, second);
    sc.close();
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
