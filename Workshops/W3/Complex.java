/**
 * Complex
 * 
 * Represents complex numbers which are combinations of real and imaginary numbers (a + bi). i = sqrt(-1)
 * Accompanying document: https://www.mathsisfun.com/numbers/complex-numbers.html
 */
public class Complex {
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
   * Adds the passed Complex number to the current object's Complex number
   * @param a - Complex number to add
   * @return total when a is added to the current object
   */
  public Complex add(Complex a) {
    
  }

  /**
   * Subtract the passed Complex number from the current object's Complex number
   * @param a - Complex number to subtract from current object' Complex Number.
   * @return the difference between the current object's complex number and the passed complex number a.
   */
  public Complex subtract(Complex a) {
    
  }

  /**
   * Multiples the current object's complex number with the passed complex number a.
   * @param a - Complex number to multiply to.
   * @return
   */
  public Complex multiply(Complex a) {
    
  }

  /**
   * Divides the current object's complex number with the passed complex number a.
   * @param a - CN to divide to
   * @return quotient
   */
  public Complex divide(Complex a) {
    
  }

  // TODO: Add abs method for absolute numbers.

}