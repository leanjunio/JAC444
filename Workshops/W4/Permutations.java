import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileWriter;
/**
 * Permutations
 */
public class Permutations {

  String digits;
  List<String> permutationsList = new ArrayList<String>(); // will contain the String permutations that are generated from the 7 digits

  final char[][] letters = {
    {'a', 'b', 'c'},
    {'d', 'e', 'f'},
    {'g', 'h', 'i'},
    {'j', 'k', 'l'},
    {'m', 'n', 'o'},
    {'p', 'r', 's'},
    {'t', 'u', 'v'},
    {'w', 'x', 'y'}
  };

  public Permutations(String digits) {
    this.digits = digits;
  }

  public String getDigits() {
    return this.digits;
  }

  public List<String> getPermutationsFromDigits() {
    char[] digitsChar = digits.toCharArray();
    
    // add an empty element into the permutationsList so that the first iteration can go through
    // if this is empty, the loop in line 43 will not proceed
    permutationsList.add("");
    
    for (char d : digitsChar) {
      List<String> next = new ArrayList<String>();
      int realIndex = d - '2';

      for (String s : permutationsList) {
        for (char c : letters[realIndex]) {
          next.add(s+c);
        }
      }
      permutationsList = next;
    }
    return permutationsList;
  }

  /**
   * Prints the permutations that are generated one by one
   */
  public void print() { 
    FileWriter fw;

    try {
      fw = new FileWriter(new File("permutations.txt"));
      List<String> perms = getPermutationsFromDigits();
  
      for (String s : perms) {
        fw.write(s);
        fw.write(System.lineSeparator());
      }
      System.out.println("All permitations written in file called permutations.txt");
      fw.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}