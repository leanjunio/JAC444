package sample;

import java.util.ArrayList;

public class Validator {
    String year;
    String gender;
    String name;
    ArrayList<Error> error;

    public Validator(String year, String gender, String name) {
        this.year = year;
        this.gender = gender;
        this.name = name;
    }

    public boolean isValid() {
        boolean nameValid = nameIsValid();
        boolean genderValid = genderIsValid();
        boolean yearValid = yearIsValid();

        return nameValid && genderValid && yearValid;
    }

    public boolean nameIsValid() {
        System.out.println("Name Entered: " + this.name);
        boolean isGreaterThanOneCharacter = this.name.length() > 0;
        boolean isAlphaNumeric = containsNumbers(this.name);
        boolean nameIsValid = isGreaterThanOneCharacter && !isAlphaNumeric;

        if (!isGreaterThanOneCharacter || isAlphaNumeric) {
            throw new IllegalArgumentException("The name should only contain letters and should be more than 1 character.");
        }
        return nameIsValid;
    }

    public boolean yearIsValid() {
        System.out.println("Year Entered: " + this.year);
        int year = Integer.parseInt(this.year);
        boolean isBetweenRange = year >= 2001 && year <= 2010;
        if (!isBetweenRange) {
            throw new IllegalArgumentException("The year has to be between 2001 and 2010. You entered: " + year);
        }
        return isBetweenRange;
    }

    public boolean genderIsValid() {
        System.out.println("Gender Entered: " + this.gender);
        String gender = this.gender.toLowerCase();
        boolean isOneCharacter = gender.length() == 1;
        boolean isValidOptions = gender.equals("m") || gender.equals("f");
        boolean isValidInput = isValidOptions && isOneCharacter;
        if (this.gender.length() == 0) {
            throw new IllegalArgumentException("Your Gender field is empty.");
        }
        if (!isValidInput) {
            throw new IllegalArgumentException("You entered an invalid input for Gender.\nMake sure that your gender is only a single character and should either only be M or F.");
        }
        return isValidInput;
    }

    public boolean containsNumbers(String s) {
        return s.matches(".*\\d+.*");
    }

    public ArrayList<Error> getError() {
        return error;
    }
}
