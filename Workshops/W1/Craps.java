/**
 * Craps
 */
import java.util.Arrays;
import java.util.Random;

public class Craps {
  private static int[] m_craps = {2, 3, 12};
  private static int[] m_natural = {7, 11};
  private static int[] m_point = {4, 5, 6, 8, 9, 10};
  private static int m_dieOne;
  private static int m_dieTwo;
  public static void main(String[] args) {
    int prev = 0;
    boolean done = false;
    int m_round = 0;

    do {
      m_round++;
      m_dieOne = rollDie();
      m_dieTwo = rollDie();
      int sum = m_dieOne + m_dieTwo;

      System.out.println("You rolled " + m_dieOne + " + " + m_dieTwo + " = " + sum);

      // If it's in round 1 and 7 is the result, the player loses and game stops
      if (m_round != 1 && sum == 7) {
        System.out.println("you lose.");
        break;
      }
      
      boolean craps_check = false;
      boolean natural_check = false;
      boolean point_check = false;

      for (int i : m_craps) {
        if (i == sum) {
          craps_check = true;  
          break;
        }
      }

      for (int i : m_natural) {
        if (i == sum) {
          natural_check = true;  
          break;  
        }
      }

      for (int i : m_point) {
        if (i == sum) {
          point_check = true;  
          break;
        }
      }

      done = sum == 7 || sum == prev;
      
      if (sum == prev || (m_round == 1 && sum == 7)) {
        System.out.println("You win");
      }
      else if (craps_check ) {
        System.out.println("you lose.");
      }
      else if (natural_check) {
        System.out.println("you win");
      }
      else if (point_check ) {
        System.out.println("Point is " + sum);
      }
      
      if (m_round > 1 && sum == 7) {
        System.out.println("You win");
        break;
      }
      
      prev = sum;
    } while (!done);
    
  }
  public static int rollDie() {
    int randomInt = new Random().nextInt(6) + 1;
    return randomInt;
  }
}