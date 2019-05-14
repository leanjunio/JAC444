/**
 * Tuition starts at 10000
 * In one year, the tuition will be $10,500. Write a program that computes the tuition in ten years and the total cost of four years
 */
public class Tuition {

  public static void main(String[] args) {
    double startingTuition = 10000;
    double currentTution = startingTuition;
    double tuitionForFourYears = 0;
    double rateOfIncreasePerYear = 0.05;
    final int YEARS = 10;

    for (int i = 0; i < YEARS; i++) {
      while (i < 4) {
        tuitionForFourYears += currentTution;
        break;
      }
      currentTution = currentTution + (currentTution * rateOfIncreasePerYear);
    }

    System.out.println("Tuition in 10 years: " + currentTution);
    System.out.println("Total tuition of 4 years: " + tuitionForFourYears);
  }
}