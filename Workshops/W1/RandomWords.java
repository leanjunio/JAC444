/**
 * RandomWords
 * A hangman game that randomly generates a word and prompts the user to guess one leter at a time
 */
import java.lang.Math;
import java.util.Scanner;
public class RandomWords {

  public static void main(String[] args) {
    String[] words = { nondocumentary, effectual, notts, ungored, dare, nonathletically, quickstep, prominent, triskele, triradii, nonaccommodating, allopathically, ddsc, koala, calenture, unconvoluted, franglais, floorcloth, firbolg, nonpliant, saprozoic, epigrammatized, hoy, staminody, dentilabial, rebreed, nonsacramental, overattention, cookless, hodur, concerned, nonwavering, electroosmotic, patroller, offeror, isagogically, hauntingly, critter, inspectoral, unhumidifying, phoenicia, enucleating, rosario, earl, corycia, mindanao, tranquilization, mphil, tedious, esteem };

    // Choose a random word from the list
    int choice = (Math.random() * words.length) - 1;
    String word = words[choice];
    
    // Re-place all characters in the string with '*'
    StringBuffer asteriskString = new StringBuffer();
    for (int i = 0; i < word.length(); i++) {
      asteriskString.append("*");
    }

    boolean isFinished = false, correctLetter = false, letterExists = false;

    while (!isFinished) {

      // Prompt user to enter a letter
      System.out.print("Enter a letter: " + asteriskString);
      Scanner sc = new Scanner(System.in);
      char letter = sc.next().charAt(0);

      // Search chosen string for letter
      int indexOfLetterChosen = word.indexOf(letter);


      // if letter entered is correct
      if (indexOfLetterChosen != -1) {
        
      }
    }
  }
}