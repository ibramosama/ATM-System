package atm_syste;

public class SavingsAccount extends Account {
// this class inhertance  data that relate customer from class account

    private double interestRate;

    public SavingsAccount() {
    }

    public SavingsAccount(double balance, double interestRate) {
        //constructor saving account object with 
        super(balance);
        this.interestRate = interestRate;
    }

    public double getInterestrate() {
        //to return inserestrate
        return interestRate;
    }

    public void setInterestrate(double interestRate) {
        // this function to set a new interesrrate
        if (interestRate > 0) {
            this.interestRate = interestRate;
        } else {
            throw new IllegalArgumentException("Interest rate must be greater than zero");
        }
    }

    public double calculateInterest() {
        // calculate interest by multiply balance * interstRate
        setBalance(getBalance() * interestRate);
        return getBalance();
    }

}
