/**
 * RandomInteger
 */
import java.lang.Math;
import java.util.Calendar;
import java.text.DateFormatSymbols;
public class RandomInteger {

  public static void main(String[] args) {
    DateFormatSymbols ds = new DateFormatSymbols();
    int generatedNumber = (int)(Math.random() * 12);
    String[] months = ds.getMonths();

    System.out.println("Month generated: " + months[generatedNumber + 1]);
  }
} 