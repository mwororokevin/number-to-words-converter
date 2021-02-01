package com.mwororokevin.application;

/**
 * @author Kevin Kamau Mwororo
 * @author website mwororokevin.com
 * @author email mwororokevin@gmail.com
 */

public class ApplicationModel {
    
    
    /**
     * Takes the Input of type string and returns an array that contains integers 
     * of the number input.
     * 
     * @param amount    Of type String. This is the number to be converted into 
     *                  words. It is received from the TextField as a String.
     * @return          An array of type Integer. This array contains the number
     *                  converted into integer grouped in threes like 1234567890 
     *                  will be returned as [1, 234, 567, 890]
     */
    private int[] getAmountAsArray(String amount) {
        int amountLength = amount.length();
        
        /**
         * Getting the length of the array by dividing the length of the String by 
         * Three and grouping the numbers into threes. i.e 3,025,369,004.
         */
        int amountArrayLength = (amountLength % 3 == 0) ? (amountLength / 3) : ((amountLength / 3) + 1);
        
//        Initialize the array the method will return with the computed size.
        int[] amountArray = new int[amountArrayLength];
        
        /**
         * Adding the elements into the array by first converting them into integers.
         * 
         * The first scenario is when the number is less than 1,000.
         * 
         * The second is when it is greater than 1,000 but the number of digits 
         * is perfectly divisible by 3. E.g. 4,000,258 or 3,125,586,369,147
         * 
         * The last scenario is when the number is greater than a thousand but
         * the total digits are not divisible by 3. E.g 42,258 or 100,258,147,369
         */        
        if(amountArrayLength <= 3)
            amountArray[0] = Integer.parseInt(amount);
        else if(amountArrayLength % 3 == 0) {
            int j = 0;
            for(int i = 0; i < amountArrayLength; i++){
                int number = Integer.parseInt(amount.substring(j, j + 3));
                amountArray[i] = number;
                j += 3;
            }
        }
        else {
            int j = amountLength % 3;
            amountArray[0] = Integer.parseInt(amount.substring(0, j));

            for(int i = 1; i < amountArrayLength; i++){
                int number = Integer.parseInt(amount.substring(j, j + 3));
                amountArray[i] = number;
                j += 3;
            }
        }
        
        
        return amountArray;
    }
}


