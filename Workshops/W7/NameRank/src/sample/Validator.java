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
        boolean isGreaterThanOneCharacter = this.name.length() > 0;
        boolean isAlphaNumeric = containsNumbers(this.name);
        boolean nameIsValid = isGreaterThanOneCharacter && !isAlphaNumeric;

        if (!isGreaterThanOneCharacter || isAlphaNumeric) {

        }
        return nameIsValid;
    }

    public boolean yearIsValid() {
        int year = Integer.parseInt(this.year);
        boolean isBetweenRange = year >= 2001 && year <= 2010;
        if (!isBetweenRange) {
            throw new IllegalArgumentException("The year has to be between 2001 and 2010. You entered: " + year);
        }
        return isBetweenRange;
    }

    public boolean genderIsValid() {
//        try {
//            System.out.println(this.gender.length());
//            genderEntered = Character.toLowerCase(this.gender.charAt(0));
//        } catch(StringIndexOutOfBoundsException s) {
//            System.out.println(s.getMessage());
//        }
        System.out.println("Gender Entered: " + this.gender);
        String gender = this.gender.toLowerCase();
        boolean isOneCharacter = gender.length() == 1;
        boolean isValidOptions = gender.equals("m") || gender.equals("f");
        boolean isValidInput = isValidOptions && isOneCharacter;
        if (!isValidInput) {
            throw new IllegalArgumentException("You entered a character of invalid choice. Only M/F is allowed.");
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
