package atm_syste;

import java.util.Scanner;

public class Transaction {
//private data fielled

    private Account acc = new Account();//object from class Account
    private double currentBalance;//to take  the new balance
    private double Amount;//to take the amount he want to (deposit or withdraw)
    private int AvaliableCash;
    private final static int INITIAL_COUNT = 500;
    private int count;

    private Scanner sc = new Scanner(System.in);

    public double getAmount() {
        //to return the amount
        return Amount;
    }

    public void setAmount(double Amount) {
        //to set a new amount
        if (Amount < 5) {
            throw new IllegalArgumentException(
                    "amount can't be smaller than 5 ");
        }
        this.Amount = Amount;
    }

    public void dispenseCash() {
        //to calculate the dispense cash
        double billsRequired = Amount / 20;
        count -= billsRequired;
    }

    public boolean isSufficientCashAvailable() {

        double billsRequired = Amount / 20;
        if (count >= billsRequired) {
            return true;
        } else {
            return false;
        }
    }

    public void setCurrentBalance(double currentBalance) {
        //to set the current balance
        this.currentBalance = currentBalance;
    }

    public void deposit() {
        //to make a deposit
        if (Amount <= 0) {
            throw new IllegalArgumentException(String.format(
                    "Invalid deposit amount %s", Amount));
        } else {
            acc.setBalance(currentBalance + Amount);
        }
    }

    public void Withdraw() {
        //to make withdraw
        if (acc.VerfyWithdrawAmount(Amount)) {
            acc.setBalance(currentBalance - Amount);
        } else {
            //if the amount greater than balnce throw the ecxeption
            throw new IllegalArgumentException(String.format(
                    "Invalid Withdraw amount %s", Amount));
        }
    }

    public String GenerateReceipt() {
//to generate receipt if the user want
        return "before this transaction the balance is : "
                + currentBalance + "\n After this transaction is : "
                + acc.getBalance();
    }

    public String KnowBlance() {
        //to make the user check to his balance
        return "your balance is " + currentBalance;
    }

    public void CancelTransaction() {
        //if the user wants to cancel transaction
        String str = "Thank you for using our ATM ";
        System.out.println(str);
        System.exit(1);
    }

    public void Fawrypaymentservices() {
        //if the user wants to make fawry payment services
        long number;
        double amount;
        System.out.print("1.Internet \t \t \t");
        System.out.println("2.Moblie number");
        int x = sc.nextInt();
        switch (x) {
            case 1:
                //for the internet
                System.out.println("enter your telephone number : ");
                number = sc.nextLong();
                System.out.println("enter the amount you want to pay for it : ");
                amount = sc.nextDouble();
                setAmount(amount);
                acc.setBalance(acc.getBalance() - Amount);
                break;
            case 2:
                //for the mobile number
                System.out.println("enter your Mobile number : ");
                number = sc.nextLong();
                System.out.println("enter the amount you want to pay for it : ");
                amount = sc.nextDouble();
                setAmount(amount);
                acc.setBalance(acc.getBalance() + Amount);
                break;
            default:
                System.out.println("error");
                System.exit(1);
                break;
        }

    }

}
