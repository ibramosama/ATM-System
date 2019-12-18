package atm_system;

public class Account {
    public static int AccountNumber;

    protected double balance;
     private Card card;
    public Account() {
    }
 
    public Account(double balance) {
        this.balance = balance;
    }

    public void credit(double amount) {
        if (amount > 0)
            this.balance += amount;
        else {
            throw new IllegalArgumentException("Credited amount must be greater than zero");
        }
    }
 
    public boolean debit(double amount) {
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
    public boolean VerfyWithdrawAmount(double amount){
    if (amount > balance&&(amount<20||amount>6000)) {
        return false;
    }
    else { 
        return true;
    }
}
    
}
    
    

