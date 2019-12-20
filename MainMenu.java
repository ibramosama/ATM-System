package atm_syste;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Date;

public class MainMenu {

    // Creating an object from class Account
    Account ac = new SavingsAccount();
    // Creating an object from class Transaction
    Transaction t1 = new Transaction();
    // Creating an object from class BankCustomer
    BankCustomer b1;
    // Creating an object from class BankCustomer use no-arg constructor
    BankCustomer b2 = new BankCustomer();
    // Creating an object from class Card
    Card c1 = new CreditCard();
    // Creating an object from class CreditCard
    CreditCard c2 = new CreditCard();
    // Creating an object from class Date 
    Date dat = new Date();
    // Creating an object from class Scanner 
    private Scanner in = new Scanner(System.in);

    // void method to print the manu of ATM
    public void DisplayMenu() {
        System.out.println("\tThank you for using our ATM ");
        System.out.print("1.Withdraw \t \t \t ");
        System.out.println("2.Deposit");
        System.out.print("3.Know Balance \t \t \t ");
        System.out.println("4.other");
    }

    // void method to print Other services
    public void other() {
        System.out.print("1.pin change \t \t \t");
        System.out.println("2. return");

    }

    // void method to read data from file
    public void read() {
        // The name of the file to open.
        // The name of the file to open.
        String fileName = "temp.txt";

        // This will reference one line at a time
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader
                    = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader
                    = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            // Always close files.
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '"
                    + fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                    + fileName + "'");

        }

    }

    // void method to Writer data from file
    public void Writer(String s) {
        try {
            FileWriter fw = new FileWriter("temp.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fw);
            try ( PrintWriter pw = new PrintWriter(bufferedWriter)) {
                pw.println();
                pw.print(s);
                pw.println();
                pw.close();
                pw.flush();
            }

        } catch (IOException e) {
            System.out.println("File not Found And"
                    + "Data is unsaved");
        }

    }

    // void method to ask user which  account he wants
    public void takeCustemerAccount() {

        System.out.println("chosse your acount : ");
        System.out.println("1.Saving Accout");
        System.out.println("2.checking Account");
        int acc = in.nextInt();
        switch (acc) {
            case 1:
                System.out.println("enter your balance ");
                double balance = in.nextDouble();
                ac.setBalance(balance);
                t1.setCurrentBalance(balance);
        }
    }

    // void method to print reciept 
    public void reciept() {
        int get_receipt;
        // ask user Whether he wants to reciept or not
        System.out.println("do you want a reciept enter  1 for reciept "
                + " or 0 if you dont need reciept ");
        get_receipt = in.nextInt();
        // if user need reciept print reciept
        if (get_receipt == 1) {
            System.out.println(dat.toString());
            System.out.println(t1.GenerateReceipt());
        }

    }

    public void main() {
        // Create boolean data files to cheek if user want back or no 
        boolean return_back;
        // ask user to enter his name and Recepion his name 
        System.out.println("please enter your name");
        String name = in.next();
        // ask user to enter his phone number and Recepion his phone number 
        System.out.println("please enter your phone number");
        long number = in.nextLong();
        // ask user to enter his email and Recepion his email 
        System.out.println("email");
        String email = in.next();
        // ask user to enter his address and Recepion his address
        System.out.println("address");
        String address = in.next();

        b1 = new BankCustomer(name, number, email, address);

        // ask user to enter his number of card and Recepion his number of card
        System.out.println("please enter your number of card ");
        long number_OfCard = in.nextLong();
        // cheek if the number of card is Valid or no
        if (!c2.isCardValid(number_OfCard)) {
            System.exit(0);
        }
        // call up the method takeCustemerAccount 
        // and this method ask user which  account he wants
        takeCustemerAccount();
        // ask user to enter expriation date of card
        // and Recepion  expriation date of card
        System.out.println("enter the expriation date ");
        String date = in.next();
        c1.setExpirationDate(date);
        // ask user to enter nuber of pin
        System.out.println("please enter your pin ");
        c1.setPin(in.nextInt());
        Writer("the name of user is " + name);
        Writer("the number of user is " + (number + ""));
        Writer("the email of user is " + email);
        Writer("the address of user is " + address);
        Writer("the number_OfCard of user is " + (number_OfCard + ""));
        do {
            //Give value false to return_back 
            return_back = false;
            // call up the method takeCustemerAccount
            // to display the menu 
            DisplayMenu();
            // ask user which transaction you want to do 
            System.out.println("please enter the number of transaction you want to do  ");
            int type_of_transaction = in.nextInt();
            int get_receipt;
            // switch case to cheek type transaction that user entered
            switch (type_of_transaction) {
                case 1:
                    // ask user to enter the amount is want to withdraw
                    System.out.println("Please enter amount you want to withdraw ");
                    t1.setAmount(in.nextDouble());
                    // call up the method Withdraw from class transaction with the object
                    // to make  Withdraw
                    t1.Withdraw();

                    // Write customer data of balance in the file 
                    Writer(" the amount you entered is "
                            + t1.getAmount() + "" + " " + t1.GenerateReceipt());
                    reciept();
                    break;
                case 2:
                    System.out.println("Please enter amount you want to deposit ");
                    t1.setAmount(in.nextDouble());
                    // call up the method deposit from class transaction with the object
                    // to make  deposit
                    t1.deposit();
                    // Write customer data  of balance in the file 
                    Writer(" the amount you entered is "
                            + t1.getAmount() + "" + " " + t1.GenerateReceipt());
                    reciept();
                    break;
                case 3:
                    // call up the method KnowBlance from class transaction with the object
                    // to KnowBlance
                    System.out.println(t1.KnowBlance());
                    break;
                case 4:
                    // call up the method other 
                    other();
                    // ask user to enter number of other trnsaction
                    System.out.println("please enter number of other trnsaction");
                    switch (in.nextInt()) {
                        case 1:
                            // ask user to enter new pin
                            System.out.println("please enter new pin");
                            // call up the method ChangePin from class BankCustomer with object
                            b2.ChangePin(in.nextInt());
                            break;
                        case 2:
                            // return back 
                            return_back = true;
                            break;
                        default:
                            System.out.println("error");
                            System.exit(1);
                            break;
                    }
                    break;
                default:
                    System.out.println("error");
                    System.exit(1);
                    break;
            }
        } while (return_back);

    }
}
