import java.util.Scanner;

/**
 * ReadingInput
 */
public class ReadingInput {
  public static void main(String[] args) {
    System.out.println("Enter a double: ");
    Scanner input = new Scanner(System.in); // System.in is the instream
    double d = input.nextDouble();
    try {
      System.out.print("You entered " + d);
    } catch (Exception e) {
      System.out.println("Error encountered: " + e.getMessage());
    } finally {
      input.close();
    }
  }
}