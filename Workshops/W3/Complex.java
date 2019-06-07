/**
 * Complex
 * 
 * The Complex number represented by this class only consists of 2 doubles (a and b), the i is added manually
 * Represents complex numbers which are combinations of real and imaginary numbers (a + bi). i = sqrt(-1)
 * Accompanying document: https://www.mathsisfun.com/numbers/complex-numbers.html
 */
import java.util.StringTokenizer;
import java.util.NoSuchElementException;

public class Complex implements Cloneable {
  final double m_real;
  final double m_imaginary;

  /**
   * Creates a complex object a + bi
   * @param a - real component
   * @param b - imaginary component
   */
  public Complex(double real, double imaginary) {
    this.m_real = real;
    this.m_imaginary = imaginary;
  }
  
  /**
   * Creates a Complex object a + 0
   * @param a - real component
   */
  public Complex(double real) {
    this.m_real = real;
    this.m_imaginary = 0;
  }

  /**
   * Creates a Complex object for 0
   */
  public Complex() {
    this.m_real = 0;
    this.m_imaginary = 0;
  }

  /**
   * Adds the passed Complex number to the current object's Complex number.
   * Formula: (a+bi) + (c+di) = (a+c) + (b+d)i
   * 
   * @param a - Complex number to add
   * @return total when a is added to the current object
   */
  public Complex add(Complex a) {
    return new Complex(this.getRealPart() + a.getRealPart(), this.getImaginaryPart() + a.getImaginaryPart());
  }

  /**
   * Subtract the passed Complex number from the current object's Complex number
   * Formula: (a+bi) - (c+di) = (a-c) + (b-d)i

   * @param a - Complex number to subtract from current object' Complex Number.
   * @return the difference between the current object's complex number and the passed complex number a.
   */
  public Complex subtract(Complex a) {
    return new Complex(this.getRealPart() - a.getRealPart(), this.getImaginaryPart() - a.getImaginaryPart());
  }

  /**
   * Multiples the current object's complex number with the passed complex number a.
   * Formula:
   *  - (a+bi)(c+di) = (ac−bd) + (ad+bc)i
   *  - (a+bi)(c+di) = ac + adi + bci + bd(i^2)
   * @param a - Complex number to multiply to.
   * @return
   */
  public Complex multiply(Complex a) {
    // (ac - bd)
    double realProduct = this.getRealPart() * a.getRealPart();
    double imaginaryProduct = this.getImaginaryPart() * a.getImaginaryPart();
    double differenceComplex = realProduct - imaginaryProduct;

    // (ad + bc)
    double RIProduct = this.getRealPart() * a.getImaginaryPart();
    double IRProduct = this.getImaginaryPart() * a.getRealPart();
    double sumComplex = RIProduct + IRProduct;
    return new Complex(differenceComplex, sumComplex);
  }

  /**
   * Divides the current object's complex number with the passed complex number a.
   * 
   * Formula:
   * - (a+bi)/(c+di) = (ac + bd)/(c^2 + d^2) + (bc - ad)i/(c^2 + d^2)
   * @param a - CN to divide to
   * @return quotient
   */
  public Complex divide(Complex a) {
    // (ac + bd)
    double acProduct = this.getRealPart() * a.getRealPart();
    double bdProduct=  this.getImaginaryPart() * a.getImaginaryPart();

    double left = acProduct + bdProduct;

    // (c^2 + d^2) NOTE: Same as on the right side
    double denom = (a.getRealPart() * a.getRealPart()) + (a.getImaginaryPart() * a.getImaginaryPart());

    // (ac + bd)/(c^2 + d^2)
    double leftQuotient = left/denom;

    // (bc - ad)i
    double rightImaginary = (this.getImaginaryPart() * a.getRealPart()) - (this.getRealPart() * a.getImaginaryPart());
    double rightQuotient = rightImaginary/denom;
    
    return new Complex(leftQuotient, rightQuotient);
  }

  /**
   * Returns the absolute value for a complex number
   * 
   * Formula: 
   * - |a + bi| = sqrt(a^2 + b^2)
   * @param a the complex number to get the absolute value of
   * @return the absolute value for the complex number passed
   */
  public static Complex abs(Complex a) {
    return new Complex(Math.sqrt((a.getRealPart() * a.getRealPart()) + (a.getImaginaryPart() * a.getImaginaryPart())));
  }

  /**
   * Getters
   */
  public double getRealPart() {
    return this.m_real;
  }
  
  public double getImaginaryPart() {
    return this.m_imaginary;
  }

  /**
   * Checks whether the ComplexNumber that was passed is valid
   */
  public static boolean validComplex(String userInput) {
    StringTokenizer s = new StringTokenizer(userInput);

    double real = 0, imaginary = 0;

    // check for the count
    boolean invalidTokenCount = (s.countTokens() != 2) ? true : false;
    boolean invalidTypes = false;
    boolean invalidValueReal = false;
    // check for valid double
    // first: convert the tokens to double
    try {
      real = Double.parseDouble(s.nextToken());
      imaginary = Double.parseDouble(s.nextToken());
    } catch (NumberFormatException e) {
      System.err.println("ERROR: Please make sure that you're only entering numbers");
      return false;
    } catch (NoSuchElementException e) {  // for 0 amount of tokens
      System.err.println("ERROR: You entered an incorrect amount of numbers, make sure that you're entering 2 numbers.");
    }

    invalidValueReal = real == 0;
    
    // if one of them is false...return false
    if (invalidTokenCount || invalidTypes || invalidValueReal) {
      if (invalidTokenCount) {
        System.err.println("ERROR: You entered an incorrect amount of numbers, make sure that you're entering 2 numbers.");
      }
      if (invalidValueReal) {
        System.err.println("ERROR: The 'real' component of your complex number is 0. Enter a number that is not 0.");
      }
      return false;
    } else {
      return true;
    }
  }
  /**
   * Returns a string representation of an object
   */
  @Override
  public String toString() {
    if (this.getImaginaryPart() == 0) {
      return String.valueOf(this.getRealPart());
    } else {
      return new String("(" + String.valueOf(this.getRealPart()) + " + " + String.valueOf(this.getImaginaryPart()) + "i)");
    }
  }
}