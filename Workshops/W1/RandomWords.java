/**
 * RandomWords
 * A hangman game that randomly generates a word and prompts the user to guess one leter at a time
 */
import java.util.Random;
import java.lang.Math;
import java.util.Scanner;
import java.util.ArrayList;;

public class RandomWords {

  public static void main(String[] args) {
    String[] words = { "nondocumentary", "effectual", "notts", "ungored", "dare", "nonathletically", "quickstep","prominent", "triskele", "triradii", "nonaccommodating", "allopathically", "ddsc", "koala", "calenture","unconvoluted", "franglais", "floorcloth", "firbolg", "nonpliant", "saprozoic", "epigrammatized", "hoy","staminody", "dentilabial", "rebreed", "nonsacramental", "overattention", "cookless", "hodur", "concerned","nonwavering", "electroosmotic", "patroller", "offeror", "isagogically", "hauntingly", "critter", "inspectoral","unhumidifying", "phoenicia", "enucleating", "rosario", "earl", "corycia", "mindanao", "tranquilization","mphil", "tedious", "esteem" };

    boolean restart = true;

    while (restart) {
      Random randomGenerator = new Random();
      int randomInt = randomGenerator.nextInt(words.length) + 1;
      String word = words[randomInt];
      char[] wordCharLetters = word.toCharArray();

      System.out.println("***** " + word.length() + " letter word *****");

      char[] wordChar = word.toCharArray();
      for (int i = 0; i < word.length(); i++) {
        wordChar[i] = '*';
      }

      boolean isFinished = false;
      ArrayList<Character> lettersTried = new ArrayList<Character>();
      int misses = 0;

      while (!isFinished) {
        System.out.print("Enter a letter from [" + wordChar[0] + "]: ");
        Scanner sc = new Scanner(System.in);
        char letter = sc.next().charAt(0);
        
        while (!Character.isLetter(letter)) {
          System.out.print("*WRONG TYPE*. Enter a LETTER from [" + wordChar[0] + "]: ");
          Scanner scan = new Scanner(System.in);
          letter = scan.next().charAt(0);
        }

        if (lettersTried.size() > 0 && lettersTried.indexOf(letter) != -1) {
          System.out.println("You've already tried this letter, try another one");
        } else {
          lettersTried.add(letter);
        }

        boolean hasFoundMatch = false;

        for (int i = 0; i < word.length(); i++) {
          if (wordCharLetters[i] == letter) {
            wordChar[i] = letter;
            hasFoundMatch = true;
          }
        }

        if (!hasFoundMatch) {
          misses++;
        }

        System.out.println(wordChar);

        if (new String(wordChar).indexOf('*') == -1) {
          System.out.println("Misses: " + misses);
          isFinished = true;
        }
      }
      
      System.out.print("Would you like to play again? Y/N: ");
      Scanner play = new Scanner(System.in);
      char letter = play.next().charAt(0);

      if (letter == 'N' || letter == 'n') {
        System.out.println("Thanks for playing! Bye!");
        play.close();
        restart = false;
      }
    }
  }
}