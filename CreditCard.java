package atm_syste;

public class CreditCard extends Card {
    // to check is card valid

    public boolean isCardValid(long number) {

        int total = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
        //to check if the total models 10 
        if ((total % 10 == 0) && (prefixMatched(number, 1) == true) && (getSize(number) >= 13)
                && (getSize(number) <= 16)) {
            return true;
        } else {
            return false;
        }
    }
    // Return this number if it is a single digit, otherwise, 
    // return the sum of the two digits 

    public int getDigit(int number) {

        if (number <= 9) {
            return number;
        } else {
            int firstDigit = number % 10;
            int secondDigit = (int) (number / 10);

            return firstDigit + secondDigit;
        }
    }

    // Return sum of odd-place digits in number 
    public int sumOfOddPlace(long number) {
        int result = 0;

        while (number > 0) {
            result += (int) (number % 10);
            number = number / 100;
        }

        return result;
    }
    // Return sum of even-place digits in number 

    public int sumOfDoubleEvenPlace(long number) {

        int result = 0;
        long temp = 0;

        while (number > 0) {
            temp = number % 100;
            result += getDigit((int) (temp / 10) * 2);
            number = number / 100;
        }

        return result;
    }

    public boolean prefixMatched(long number, int d) {
        // Return true if the digit d is a prefix for number 
        String card;
        if ((getPrefix(number, d) == 4)
                || (getPrefix(number, d) == 5)
                || (getPrefix(number, d) == 6)
                || (getPrefix(number, d) == 37)) {

            if (getPrefix(number, d) == 4) {
                card = ("Visa ");
            } else {
                card = ("unknown");
            }

            return true;

        } else {

            return false;

        }
    }

    // Return the number of digits in d 
    public int getSize(long d) {

        int count = 0;

        while (d > 0) {
            d = d / 10;

            count++;
        }

        return count;

    }
// Return the first k number of digits from  
    // number. If the number of digits in number 
    // is less than k, return number. 

    public long getPrefix(long number, int k) {

        if (getSize(number) < k) {
            return number;
        } else {

            int size = (int) getSize(number);

            for (int i = 0; i < (size - k); i++) {
                number = number / 10;
            }

            return number;

        }

    }
// return type  

    public String getCardType(long x) {
        x = super.getId();
        String type;
        if (isCardValid(x)) {
            String y = x + "";
            if (y.startsWith("4")) {
                type = "Visa";
            } else if (y.startsWith("5")) {
                type = "MasterCard";
            } else {
                type = "unknown";
            }
        }
        return "";
    }

}
