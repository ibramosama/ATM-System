package atm_syste;

import java.util.ArrayList;
//this class made to display customer data 

public class BankCustomer {
//private data fields to made customer data private 

    private String Name;
    private long number;
    private String email;
    private String address;
    private ArrayList<Account> accounts = new ArrayList<Account>();
    private ArrayList<Card> card = new ArrayList<Card>();
    private CreditCard c = new CreditCard();

    public BankCustomer(String Name, long number, String email, String address) {
        //Constructs a customer object with the specified customer data
        this.Name = Name;
        this.number = number;
        this.email = email;
        this.address = address;
    }

    public BankCustomer() {
        //no arg constructor
    }

    public String getname() {
        // to return  the name of customer
        return Name;
    }

    public void setnumber(int number) {
        // set anew number for customer
        this.number = number;
    }

    public long getnumber() {
        //return number of the customer
        return number;
    }

    public void setaddress(String addrees) {
        //sets new address for customer
        this.address = address;
    }

    public String getaddress() {
        //return address of the customer
        return address;
    }

    public void setemail(String email) {
        //sets new email for customer
        this.email = email;
    }

    public String getemail() {
        //return email of the email
        return email;
    }

    public void Add_Account(Account new_Account) {
        //if the customer have more than one account 
        this.accounts.add(new_Account);
        Account.AccountNumber++;

    }

    public void Remove_Account(Account account) {
        // to give the customer option to delete account
        this.accounts.remove(account);
        Account.AccountNumber--;
    }

    public void ChangePin(int pin) {
        // to give customer obtion to change his password
        c.setPin(pin);
    }

    public String DisplayCustomerData() {
        // to display bank customer data 
        return "BankCustomer{" + "Name=" + Name + ", number=" + number + ", email=" + email
                + ", address=" + address + ", accounts=" + accounts + ", card=" + card + ", c=" + c + '}';
    }

}
