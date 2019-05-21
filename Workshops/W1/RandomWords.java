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
    char[] wordCharLetters = word.toCharArray();
    
    System.out.println("***** " + word.length() + " letter word *****");

    // Re-place all characters in the string with '*'
    char[] wordChar = word.toCharArray();
    for (int i = 0; i < word.length(); i++) {
      wordChar[i] = '*';
    }

    boolean isFinished = false;

    while (!isFinished) {

      System.out.print("Enter a letter from [" + wordChar[0] + "]: ");
      Scanner sc = new Scanner(System.in);
      char letter = sc.next().charAt(0);
      String triedLetters = "";
      int misses = 0;

      // triedLetters += Character.toString(letter);

      // if (triedLetters.length() > 0) {
      //   if (triedLetters.indexOf(letter) != -1) {
      //     System.out.println("You've already used this letter: " + letter);
      //   }
      // }
      
      for (int i = 0; i < word.length(); i++) {
        if (wordCharLetters[i] == letter) {
          wordChar[i] = letter;
        } else {
          misses++;
        }
      }

      System.out.println(wordChar);

      // checks if the word is finished
      if (new String(wordChar).indexOf('*') == -1) {
        System.out.println("Misses: " + misses);
        isFinished = true;
      }
    }
  }
}