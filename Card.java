package atm_syste;

import java.util.regex.Pattern;

public abstract class Card {

    private int pin;
    private long id;
    private int cvv;
    private String expirationDate;
    private String nameOnCard;

//This is a no-arg constructor
    public Card() {
    }

    public Card(String nameOnCard, String number, int cvv, String expirationDate) {
        //This is the constructor
        this.pin = pin;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.nameOnCard = nameOnCard;
    }
//returns card name ie credit or depit  

    public String getNameOnCard() {
        return nameOnCard;
    }
    //set a new id for that card

    public void setId(long id) {
        this.id = id;
    }
//set a new pin for this card

    public void setPin(int pin) {
        if (isPinValid(pin)) {
            this.pin = pin;
        } else {
            throw new IllegalArgumentException(
                    " pin can't be more than 4 numbers and not less than 4");
        }

    }
    // to check is pin valied or not

    public boolean isPinValid(int pin) {
        boolean result = false;
        String pi = pin + "";

        if (pi.length() == 4) {
            result = true;
        }
        return result;
    }

    // set a new cvv for this card
    public void setCvv(int cvv) {
        String CVV = cvv + "";
        if (CVV.length() != 3) {
            System.out.println("cvv  must be 3 numbers");
        }
        this.cvv = cvv;
    }
    // set a new expirationDate for that card

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    //return pin for this card

    public int getPin() {
        return pin;
    }
    //this method to return Id number

    public long getId() {
        return id;
    }
//this method to retunr cvv number

    public int getCvv() {
        return cvv;
    }
    //this method to return expirationDate

    public String getExpirationDate() {
        return expirationDate;
    }

}
