package org.example.learnlib;

import java.io.Serializable;
import java.util.Date;

/**
 * Account
 */
public class Account implements Serializable {
  private int id = 0;
  String firstName;
  String lastName;
  private double balance = 0;
  private double annualInterestRate = 0;
  private Date dateCreated;

  /**
   * Default constructor - creates empty Account
   */
  public Account() {
    this.dateCreated = new Date();
    this.firstName = "";
    this.lastName = "";
  }

  public Account(int id, double balance) {
    this.id = id;
    this.balance = balance;
  }

  /**
   * id accessors/mutators
   */
  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return this.id;
  }

  /**
   * balance accessors/mutators
   */
  public void setBalance(double balance) {
    this.balance = balance;
  }

  public double getBalance() {
    return this.balance;
  }

  /**
   * annualInterestRate accessors/mutators
   */

  /**
   * Sets the annualInterestRate of the current account
   * @param annualInterestRate
   */
  public void setAnnualInterestRate(double annualInterestRate) {
    this.annualInterestRate = annualInterestRate;
  }

  /**
   * Returns the annualInterestRate of the current account
   * @return
   */
  public double getAnnualInterestRate() {
    return this.annualInterestRate;
  }

  /**
   * dateCreated Accessor
   */
  public Date getDateCreated() {
    return this.dateCreated;
  }

  /**
   * Calculates the monthly interest rate for the account
   * @return monthlyInterestRate in decimal form
   */
  public Double getMonthlyInterestRate() {
    double monthlyInterestRate = this.getAnnualInterestRate() / 12;
    return monthlyInterestRate / 100;
  }

  /**
   * Calculates the monthly interest based on the monthlyInterestRate and the balance of the account
   * @return monthlyInterest
   */
  public Double getMonthlyInterest() {
    double monthlyInterest = this.getMonthlyInterestRate() * this.getBalance();
    return monthlyInterest;
  }

  /**
   * Withdraws a specified amount from the account
   * @param amount
   */
  public void withdraw(double amount) {
    this.setBalance(this.getBalance() - amount);
  }

  /**
   * Deposits a specified amount from the account
   * @param amount
   */
  public void deposit(double amount) {
    this.setBalance(this.getBalance() + amount);
  }
}