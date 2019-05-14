/**
 * population
 * 
 * A program that displays the population for each of the next five years
 * Assume that the current population is 312,032,486 and one year has 365 days
 * Don't forget the decimal part
 */

public class population {

  public static void main(String[] args) {
    double currentPopulation = 312032486;
    final int BRPS = 7;
    final int DRPS = 13;
    final int NIPS = 45;

    // Calculate the seconds in 1 year
    final int SECONS_PER_YEAR = 60 * 60 * 24 * 365;

    // Calculate the rates per year
    // Births per year
    double birthsYear = SECONS_PER_YEAR/BRPS;

    // deaths in a year
    double deathsYear = SECONS_PER_YEAR/DRPS;

    // new immigrants in a year
    double immigrantsYear = SECONS_PER_YEAR/NIPS;

    // Display the population for the next 5 years
    for (int i = 0; i < 5; i++) {
      currentPopulation = birthsYear + immigrantsYear;
      currentPopulation -= deathsYear;
    }

    System.out.println("The population after 5 years: " + currentPopulation);
  }
}