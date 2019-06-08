/**
 * BankMain
 */
import java.lang.NumberFormatException;
import java.util.Scanner;
public class BankMain {

  public static void main(String[] args) {
    System.out.println("TESTING BANK.................................................");
    
    Scanner scan = new Scanner(System.in);
    boolean validNumBanks = false;
    int minAsset = 0;
    int numBanks = 0;
    do {
      try {
        System.out.print("Number of banks: ");
        String n = scan.nextLine();
        numBanks = Integer.parseInt(n);
        validNumBanks = numBanks > 0; 

        System.out.println("Minimum asset limit: ");
        String s = scan.nextLine();
        minAsset = Integer.parseInt(s);

      } catch (NumberFormatException e) {
        System.err.println("Error encountered: " + e.getMessage() + " Please enter an Integer");
      }
    } while (!validNumBanks);

    // after entering numbers
    for (int i = 0; i < numBanks; i++) {
      System.out.println("Bank # " + i);

      boolean validInfo = false;
      do {
        try {
          System.out.print("Balance: ");
          String n = scan.nextLine();
          double balance = Double.parseDouble(n);
          
          System.out.print("Number of banks loaned: ");
          String l = scan.nextLine();
          int numBanksLoaned = Integer.parseInt(l);

          for (int x = 0; x < numBanksLoaned; x++) {
            System.out.println("Bank ID: ");
            String id = scan.nextLine();
            int intID = Integer.parseInt(id);

          }

        } catch (NumberFormatException e) {
          System.err.println("Error encountered: " + e.getMessage() + " Please enter an Integer");
        }
      } while (!validInfo);
    }
  }
}