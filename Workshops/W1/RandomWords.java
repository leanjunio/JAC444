/**
 * RandomWords
 * A hangman game that randomly generates a word and prompts the user to guess one leter at a time
 */
import java.util.Random;
import java.lang.Math;
import java.util.Scanner;
public class RandomWords {

  public static void main(String[] args) {
    String[] words = { "nondocumentary", "effectual", "notts", "ungored", "dare", "nonathletically", "quickstep", "prominent", "triskele", "triradii", "nonaccommodating", "allopathically", "ddsc", "koala", "calenture", "unconvoluted", "franglais", "floorcloth", "firbolg", "nonpliant", "saprozoic", "epigrammatized", "hoy", "staminody", "dentilabial", "rebreed", "nonsacramental", "overattention", "cookless", "hodur", "concerned", "nonwavering", "electroosmotic", "patroller", "offeror", "isagogically", "hauntingly", "critter", "inspectoral", "unhumidifying", "phoenicia", "enucleating", "rosario", "earl", "corycia", "mindanao", "tranquilization", "mphil", "tedious", "esteem" };

    // Choose a random word from the list
    Random randomGenerator = new Random();
    int randomInt = randomGenerator.nextInt(words.length) + 1;
    String word = words[randomInt];
    
    // Re-place all characters in the string with '*'
    String asteriskString[] = {""};
    for (int i = 0; i < word.length(); i++) {
      asteriskString[i] = "*".toString();
    }
 
    boolean isFinished = false, correctLetter = false, letterExists = false;

    while (!isFinished) {

      // Prompt user to enter a letter
      System.out.print("Enter a letter from [" + asteriskString.toString() + "]: ");
      Scanner sc = new Scanner(System.in);
      char letter = sc.next().charAt(0);

      // Search chosen string for letter
      int indexOfLetterChosen = word.indexOf(letter);

      // if letter entered is correct
      if (indexOfLetterChosen != -1) {
        asteriskString[indexOfLetterChosen] = letter;
      }
    }
  }
}