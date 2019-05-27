/**
 * Craps
 */
import java.util.Random;

public class Craps {
  private static int m_dieOne;
  private static int m_dieTwo;
  private static int m_currentPoint;
  public static void main(String[] args) {
    boolean done = false;

    int m_dieOne = rollDie();
    int m_dieTwo = rollDie();
    int sum = m_dieOne + m_dieTwo;
    int prevSum = sum;
    System.out.println("You rolled " + m_dieOne + " + " + m_dieTwo + " = " + sum);

    while (!done) {
      boolean craps = sum == 2 || sum == 3 || sum == 12;
      boolean naturals = sum == 7 || sum == 11;

      if (craps) {
        System.out.println("You lose.");
        done = true;
      }
      else if (naturals) {
        System.out.println("You win.");
        done = true;
      }
      else {
        m_currentPoint = sum;
        System.out.println("The point has been established to be: " + m_currentPoint);
        do {
          m_dieOne = rollDie();
          m_dieTwo = rollDie();
          sum = m_dieOne + m_dieTwo;
          System.out.println("You rolled " + m_dieOne + " + " + m_dieTwo + " = " + sum);
          if (sum == m_currentPoint || sum == prevSum) {
            System.out.println("You win.");
            done = true;
            break;
          }
          if (sum == 7) {
            System.out.println("You lose.");
            done = true;
            break;
          }
          prevSum = sum;
        } while (sum != m_currentPoint || sum != 7);
      }
    }
  }
  public static int rollDie() {
    int randomInt = new Random().nextInt(6) + 1;
    return randomInt;
  }
}