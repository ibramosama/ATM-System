package atm_system;

public class CheckingAccount extends Account {

    private double fee;

    public CheckingAccount(double balance, double fee) {
        super(balance);
        this.fee = fee;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        if (this.fee > 0); else {
            throw new IllegalArgumentException("Fee cannot be less than zero");
        }
    }

    public void credit(double amount) {
        super.credit(amount);
        this.balance -= this.fee;
    }

    public boolean debit(double amount) {
        if (super.debit(amount)) {
            this.balance -= this.fee;
            return true;
        } else {
            return false;
        }
    }
}
