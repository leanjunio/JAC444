import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * TesterClass
 */
public class TesterClass {
  public static void main(String[] args) throws NumberRestrictionException {
    System.out.println("NOTE: Please comment and uncomment between the two functions below. In file TesterClass.java Line 12 and Line 13");
    runFile();      // task 1
    runNumbers();   // task 2
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

  public static void runNumbers() throws NumberRestrictionException {
    int numbers = 0;
    boolean validNumbers = false;
    Scanner sc = new Scanner(System.in);

    do {
      System.out.print("Enter 7 digits: ");
      try {
        numbers = Integer.parseInt(sc.nextLine());

        boolean numberRestriction = Integer.toString(numbers).matches("[2-9]+");
        boolean minimumSevenDigits = Integer.toString(numbers).length() == 7;

        if (numberRestriction && minimumSevenDigits) {
          validNumbers = true;
        } else if(!numberRestriction) {
          NumberRestrictionException nre = new NumberRestrictionException("You entered a number outside of the boundaries (2 - 9). Try again.");
          throw nre;
        } else if(!minimumSevenDigits) {
          NumberLengthException nle = new NumberLengthException("You didn't reach the correct length. The length must be 7. Try again.");
          throw nle;
        }
      } catch (InputMismatchException e) {
        System.err.println("ERR: The token retrieved does not match the pattern for the expected type, or that the token is out of range for the expected type.");
      } catch (NumberRestrictionException e) {
        System.out.println(e.getLocalizedMessage());
      } catch (NumberFormatException e) {
        System.err.println("ERR: The application has attempted to convert a string to one of the numeric types, but that the string does not have the appropriate format.");
      } catch (NumberLengthException e) {
        System.err.println(e.getLocalizedMessage());
      }
    } while (!validNumbers);

    System.out.println("Generating possible 7 letter word combinations...");

    Permutations p = new Permutations(Integer.toString(numbers));
    p.print();
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
      sc.reset();
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