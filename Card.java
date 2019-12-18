
package atm_system;

import java.util.regex.Pattern;

public abstract class Card {
    

    private String pin;
    private long id;
    private int cvv;
    private String expirationDate;
    private String nameOnCard;

    public Card() {
    }
public Card(String nameOnCard, String number, int cvv, String expirationDate) {
        this.pin = pin;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.nameOnCard = nameOnCard;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }
    

    
   

    public void setId(long id) {
        this.id = id;
    }
    
    


    public void setPin(String pin) {
        if (isPinValid(expirationDate)) {
            this.pin = pin;
        }

    }

    public boolean isPinValid(String pin) {
        if (Pattern.matches("[0-9]+", pin) && pin.length() == 4) {
            return true;
        } else {
            return false;
        }
    }

   
    public void setCvv(int cvv) {
        String CVV=cvv+"";
        if (CVV.length()!=3){
            System.out.println("cvv  must be 3 numbers");
        }
        this.cvv = cvv;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPin() {
        return pin;
    }

    public long getId() {
        return id;
    }

    public int getCvv() {
        return cvv;
    }

    public String getExpirationDate() {
        return expirationDate;
    }
  

   
}
