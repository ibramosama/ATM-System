package atm_syste;

public class CheckingAccount extends Account {
//private data fieled

    private double fee;

    public CheckingAccount(double balance, double fee) {
        //constructor with data filled
        super(balance);
        this.fee = fee;
    }

    public double getFee() {
        //method to return fee
        return fee;
    }

    public void setFee(double fee) {
        // set a new fee 
        if (this.fee > 0); else {
            throw new IllegalArgumentException("Fee cannot be less than zero");
        }
    }

    @Override
    public void credit(double amount) {
        //to calculate the balance with its fee
        super.credit(amount);
        setBalance(getBalance() - this.fee);
    }

    @Override
    public boolean debit(double amount) {
        //to calculate the balance with its fee
        if (super.debit(amount)) {
            setBalance(getBalance() - this.fee);
            return true;
        } else {
            return false;
        }
    }
}
