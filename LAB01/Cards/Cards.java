/**
 * Cards
 * A program that simulates picking a card from a deck of 52 cards. Your program
 * should display the rank (Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King) and suit (Clubs, Diamonds, Hearts, Spades) of the card
 */
import java.lang.Math;
public class Cards {
  public static void main(String[] args) {
    int generateRank = (int)(Math.random() * 13);
    int generateSuite = (int)(Math.random() * 4);
    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    System.out.println("The card you picked is " + ranks[generateRank] + " of " + suits[generateSuite]);
  }
}