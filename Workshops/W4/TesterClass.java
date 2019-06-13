import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * TesterClass
 */
public class TesterClass {
  public static void main(String[] args) {
    // runFile();
    runNumbers();
  }

  /**
   * Checks how many times a letter exists in a file
   * @param letter - the letter to check against
   * @param file - the file that needs to be checked
   * @return the amount of times the letter exists in the file
   */
  public static int checkForLetter(char letter, String file) {
    int ch, count = 0;
    try {
      FileReader fr = new FileReader(file);
      while ((ch = fr.read()) != -1) {
        if ((char)ch == letter) {
          count++;
        }
      }
      fr.close();
    } catch (Exception e) {
      System.err.println(e.getCause());
    }
    return count;
  } 

  public static void runNumbers() {
    String numbers = null;
    boolean validNumbers = false;
    Scanner sc = new Scanner(System.in);

    do {
      System.out.print("Enter 7 digits: ");
      try {
        numbers = sc.nextLine();
        if (numbers.matches("[0-9]+") && numbers.length() == 7) {
          validNumbers = true;
        } else {
          System.out.println("You entered 1 or more letters. Try again and only enter 7 numbers.");
          validNumbers = false;
        }
      } catch (Exception e) {
        System.err.println(e.getLocalizedMessage());
      }
      System.out.println("Generating possible 7 letter word combinations...");
    } while (!validNumbers);
  }

  /**
   * The method that runs Task 1
   */
  public static void runFile() {
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    
    Scanner sc = new Scanner(System.in);
    String file;

    FileReader fr = null;
    boolean validFile = false;

    do {
      System.out.print("Enter a filename: ");
      file = sc.nextLine();
      try {
        fr = new FileReader(file);
        validFile = true;
      } catch (FileNotFoundException e) {
        System.err.println("ERROR:"+ e.getLocalizedMessage());
      }
    } while (!validFile);

    for (char l : alphabet) {
      int n = checkForLetter(l, file);
      System.out.println("Number of " + l + " : " + n);
    }

    sc.close();
  }
}