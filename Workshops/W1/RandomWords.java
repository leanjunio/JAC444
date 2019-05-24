/**
 * RandomWords
 * A hangman game that randomly generates a word and prompts the user to guess one leter at a time
 */
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class RandomWords {
  private static StringBuilder m_chosenWord;
  private static char[] m_asteriskVersionOfChosenWord;
  private static ArrayList<Character> m_lettersTried = new ArrayList<Character>();
  public static int m_misses;
  public static void main(String[] args) {
    String[] words = { "nondocumentary", "effectual", "notts", "ungored", "dare", "nonathletically", "quickstep","prominent", "triskele", "triradii", "nonaccommodating", "allopathically", "ddsc", "koala", "calenture","unconvoluted", "franglais", "floorcloth", "firbolg", "nonpliant", "saprozoic", "epigrammatized", "hoy","staminody", "dentilabial", "rebreed", "nonsacramental", "overattention", "cookless", "hodur", "concerned","nonwavering", "electroosmotic", "patroller", "offeror", "isagogically", "hauntingly", "critter", "inspectoral","unhumidifying", "phoenicia", "enucleating", "rosario", "earl", "corycia", "mindanao", "tranquilization","mphil", "tedious", "esteem" };
    boolean restart = true;

    while (restart) {
      clearAttributes();
      m_chosenWord = getRandomWord(words);
      System.out.println("***** " + m_chosenWord.length() + " letter word *****");
      
      playGame();
      boolean validInput = false;
      String letter;
      do {
        System.out.print("Would you like to play again? Y/N: ");
        Scanner sc = new Scanner(System.in);
        letter = sc.nextLine();
        validInput = validYesNo(letter.charAt(0));
      } while (!validInput);
      
      if (Character.toLowerCase(letter.charAt(0)) == 'n') {
        restart = false;
      }
    }
    System.out.println("Thank you for playing! Goodbye!");
  }
  /**
   * Clears the attributes of the class so that the next round's data can be reset
   */
  public static void clearAttributes() {
    m_lettersTried.clear();
    m_misses = 0;    
  }

  /**
   * Chooses a random word from the array of Strings passed and returns one of them.
   * 
   * @param words String[] that contains words that can be randomly chosen from
   * @return the chosen word
   */
  public static StringBuilder getRandomWord(String[] words) {
    int randomInt = new Random().nextInt(words.length) + 1;
    return new StringBuilder(words[randomInt]);
  }

  /**
   * Checks if the user input when asked to play again is a valid input or not.
   * 
   * @param input The user input to check if valid
   * @return the result of checking whether the input is valid or not
   */
  public static boolean validYesNo(char input) {
    boolean isLetter = Character.isLetter(input);
    boolean isYorN = Character.toLowerCase(input) == 'y' || Character.toLowerCase(input) == 'n';
    if (!isYorN || !isLetter) {
      System.err.println("The character that you've entered is either Y or N, Please enter one of these two letters to proceed.");
    }
    return isLetter && isYorN;
  }

  /**
   * Checks whether the user's guessed letter is a valid letter. 
   * 
   * @param letter The letter that the user guessed
   * @return boolean that checks whether the letter is valid or not
   */
  public static boolean validLetterChoice(String letter) {
    boolean isValid = letter.length() == 1 && Character.isLetter(letter.charAt(0));
    boolean isUsed = m_lettersTried.size() > 0 && m_lettersTried.indexOf(letter.charAt(0)) != -1;

    if (!isValid) {
      System.err.println("ERROR: The character that you inputted consists of more than 1 chracter or is not a letter.");
    } else if (isUsed) {
      System.err.println("You've already tried this letter. Choose another one.");
    }

    return !isUsed && isValid;
  }
  
  /**
   * Returns an asterisk version of the word passed to it
   * 
   * @param word The word to convert into asterisks
   * @return The asterisk version of the word
   */
  public static char[] getAteriskWord(StringBuilder word) {
    m_asteriskVersionOfChosenWord = word.toString().toCharArray();
    Arrays.fill(m_asteriskVersionOfChosenWord, '*');
    return m_asteriskVersionOfChosenWord;
  }

  /**
   * This function asks the user for a letter to guess
   * 
   * If the letter that the user guesses is invalid, an error will come up
   * @return the valid letter that the user guessed
   */
  public static char getUserLetterGuess() {
    System.out.print("Enter a letter [" + new String(m_asteriskVersionOfChosenWord) + "]: ");
    Scanner sc = new Scanner(System.in);
    String letter = sc.next();

    boolean validLetter = validLetterChoice(letter);
    while (!validLetter) {
      System.out.print("Enter a letter [" + new String(m_asteriskVersionOfChosenWord) + "]: ");
      sc = new Scanner(System.in);
      letter = sc.next();
      validLetter = validLetterChoice(letter);
    }

    m_lettersTried.add(letter.charAt(0));
    return letter.charAt(0);
  }

  /**
   * Checks if the letter entered by the user has a match
   * 
   * @param letter - The letter guessed by the user
   * @return 
   */
  public static boolean checkForMatch(char letter) {
    boolean hasFoundMatch = false;
    for (int i = 0; i < m_chosenWord.length(); i++) {
      if (m_chosenWord.charAt(i) == letter) {
        m_asteriskVersionOfChosenWord[i] = letter;
        hasFoundMatch = true;
      }
    }
    return hasFoundMatch;
  }
  /**
   * Runs the game for one round
   */
  public static void playGame() {
    char[] asteriskVersionOfChosenWord = getAteriskWord(m_chosenWord);
    m_misses = 0;
    boolean isFinished = false;
    do {
      char letterInput = getUserLetterGuess();
      boolean match = checkForMatch(letterInput);
      if (!match) {
        System.out.println("~~~ The letter " + letterInput + " is not in the word.");
        m_misses++;
      }
      else
        System.out.println("***** The letter [" + letterInput + "] is in the word! *****");

      if (new String(asteriskVersionOfChosenWord).indexOf('*') == -1) {
        System.out.println("The word that you guessed is: [" + new String(asteriskVersionOfChosenWord) + "]");
        System.out.println("Misses: " + m_misses);
        isFinished = true;
      }
    } while (!isFinished);
  }
}