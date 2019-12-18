
package atm_system;
public class SavingsAccount extends Account {
private double interestRate;
 
  
    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }
     
    public double getInterestrate() {
        return interestRate;
    }
 
    public void setInterestrate(double interestRate) {
        if (interestRate > 0)
            this.interestRate = interestRate;
        else {
            throw new IllegalArgumentException("Interest rate must be greater than zero");
        }
    }
 
    public double calculateInterest() {
        return balance * interestRate;
    }   
    }