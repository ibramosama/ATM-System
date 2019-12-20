package atm_syste;

public class Account {

    public static int AccountNumber;//make the static variable to return no of accounts 
    protected double balance;//a protected variable to make only the subclasses can take the value of balance
    private Card card; //a private object from class Card

    public Account() {
    }

    public double getBalance() {
        //to return the balance
        return balance;
    }

    public void setBalance(double balance) {
        //to set a the balance for a customer
        this.balance = balance;
    }

    public Account(double balance) {
        // constructor with one arguments 
        this.balance = balance;
    }

    public void credit(double amount) {
        //to add the amount to balnce
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new IllegalArgumentException("Credited amount must be greater than zero");
        }
    }

    public boolean debit(double amount) {
        //to subtract the amount to balnce
        boolean OK = true;
        if (this.balance - amount >= 0) {
            this.balance -= amount;
            OK = true;
        } else {
            System.out.print("Debited amount exceeded account balance");
            OK = false;
        }
        return OK;
    }

    public boolean VerfyWithdrawAmount(double amount) {
        //to check if the withdrawamount is true or not 
        return !((amount > balance) && (amount < 20 || amount > 8000));
    }

}
