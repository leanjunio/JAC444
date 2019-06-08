/**
 * Bank
 */
public class Bank {
  static int counter = 0;
  int bankId;
  double totalAsset;

  public int getBankId() {
    return this.bankId;
  }

  public double getTotalAsset() {
    return this.totalAsset;
  }

  public double getCurrentBalance() {
    return this.currentBalance;
  }

  public int getNumLoans() {
    return this.numLoans;
  }

  public Bank[] getLoanedBanks() {
    return this.loanedBanks;
  }
  double currentBalance;
  int numLoans;
  Bank[] loanedBanks; // banks assets are loaned to by the current object
  
  public Bank(int id, int numLoans, double balance) {
    this.bankId = id;
    this.numLoans = numLoans;
    this.currentBalance = balance;
    this.loanedBanks = new Bank[numLoans];
  }
}