package atm_system;

import java.util.ArrayList;

public class BankCustomer {

    private String Name;
    private int number;
    private String email;
    private String address;

    private ArrayList<Account> accounts = new ArrayList<Account>();
    private ArrayList<Card> card = new ArrayList<Card>();
    private  Card c;

    public BankCustomer() {
    }

    public String getname() {
        return Name;
    }

    public void setnumber(int number) {
        this.number = number;
    }

    public int getnumber() {
        return number;
    }

    public void setaddress(String addrees) {
        this.address = address;
    }

    public String getaddress() {
        return address;
    }

    public void setemail(String email) {
        this.email = email;
    }

    public String getemail() {
        return email;
    }

    public void Add_Account(Account new_Account) {
        this.accounts.add(new_Account);
        Account.AccountNumber++;

    }

    public void Remove_Account(Account account) {
        this.accounts.remove(account);
        Account.AccountNumber--;
    }
    public void ChangePin(int pin) {
        c.setPin(pin+"");
    }


    public String DisplayCustomerData() {
        return "BankCustomer{" + "Name=" + Name + ", number=" + number + ", email=" + email +
                ", address=" + address + ", accounts=" + accounts + ", card=" + card + ", c=" + c + '}';
    }

}
