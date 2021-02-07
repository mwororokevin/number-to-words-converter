package com.mwororokevin.application;

/**
 * @author Kevin Kamau Mwororo
 * @author website mwororokevin.com
 * @author email mwororokevin@gmail.com
 */

public class ApplicationModel {
    
//    Holds the word equivalent of the numbers below Twenty.
    private String[] numbersLessThanTwenty = {"", "One ", "Two ", "Three ", "Four ", 
        "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", 
        "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", 
        "Nineteen "};
    
    /**
     * Holds the name equivalents of the numbers of the multiples of ten 
     * e.g Ten, Twenty, ... Fifty and so on
     */
    private String[] multiplesOfTens = {"", "", "Twenty ", "Thirty ", "Forty ", 
        "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "}; 
    
    /**
     * Holds the names of the multiples of thousand by thousands i.e 
     * million, billion, Trillion etc.
     */
    private String[] thousands = {"Vigintillion ", "Novemdecillion ", 
        "Octodecillion ", "Septendecillion ", "Sexdecillion ", "Quindecillion ", 
        "Quattuordecillion ", "Tredecillion ", "Duodecillion ", "Undecillion ",
        "Decillion ", "Nonillion ", "Octillion ", "Septillion ", "Sextillion ", 
        "Quintillion ", "Quadrillion ", "Trillion ", "Billion ", "Million ", 
        "Thousand ", ""};
    
    /**
     * The length of the thousands array. Will be used in combining the entire 
     * number in figures.
     */
    private int thousandsArrayLength = thousands.length;
    
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
        int amountArrayLength = (amountLength % 3 == 0) ? (amountLength / 3) : 
                ((amountLength / 3) + 1);
        
//        Initialize the array the method will return with the computed size.
        int[] amountArray = new int[amountArrayLength];
        
        /**
         * Adding the elements into the array by first converting them into integers.
         * 
         * The first scenario is when the number is less than 1,000.
         * 
         * The second is when it is greater than 1,000 but the number of digits 
         * is perfectly divisible by 3. E.g. 425,000,258 or 369,125,586,369,147
         * 
         * The last scenario is when the number is greater than a thousand but
         * the total digits are not divisible by 3. E.g 42,258 or 100,258,147,369
         */        
        if(amountArrayLength == 1)
            amountArray[0] = Integer.parseInt(amount);
        else if(amountLength % 3 == 0) {
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
    
    /**
     * Takes a single integer parameter between 1 and 1000 in size and returns a 
     * String representing the number in words. E.g it takes 1 to 999 and returns
     * One to Nine Hundred and Ninety Nine.
     * 
     * @param number    Of type Integer less than 1000 but greater than 1.
     * @return          A String representing the number in words
     */
    private String getAmounInWords(int number) {
        String inWords = "";
        
        /**
         * If the number is less than 20 it gets it's value from the 
         * numbersLessThanTwenty map.
         * 
         * If number is less than 100 and greater than 19 it gets its value from 
         * the combination of the values from the multiplesOfTens and 
         * numbersLessThanTwenty maps
         * 
         * If number is greater than 99 and less than 1000 it gets it's value from 
         * numbersLessThanTwenty map for the Hundred value and multiplesOfTens 
         * map for the Tens and the numbersLessThanTwenty for the remainder.
         */
        if(number < 20) 
            inWords = numbersLessThanTwenty[number];
        else if(number > 19 && number < 100) 
            inWords = multiplesOfTens[(number / 10)] + 
                    numbersLessThanTwenty[(number % 10)];
        else if(number > 99 && number < 1000) {
            if(number % 100 == 0)
                inWords = numbersLessThanTwenty[(number / 100)] + "Hundred ";
            else
                inWords = numbersLessThanTwenty[(number / 100)] + "Hundred and " + 
                        multiplesOfTens[(number % 100) / 10] + 
                        (((number % 100) < 20) ? (numbersLessThanTwenty[number % 100]) :
                        numbersLessThanTwenty[(number % 10) % 10]);
        }
        
        return inWords;
    }
    
    /**
     * Takes the number in String form from the TextField and converts it into words.
     * 
     * @param number    Of type String containing the number to be converted to words.
     * @return          A String of the number converted into words.
     */
    public String getInWords(String number) {
        String inWords = "";
        
        /**
         * The Array of type integer converted from the String number by the 
         * getAmountAsArray Method. It is used to get the digits for conversion
         * by the getAmounInWords method.
         */
        int[] numberArray = getAmountAsArray(number);
        
        /**
         * Loop through the entire array starting with the left most numbers of 
         * Whole Number to be converted assigning thousands, millions etc from the 
         * thousands array as needed and adding the rest of the words.
         */
        for(int i = 0; i < numberArray.length; i++) {
            int figure = numberArray[i];
            
            inWords += getAmounInWords(figure) + ((figure > 0) ? 
                    (thousands[(thousandsArrayLength - numberArray.length + i)]) : "");
        }
        
        return inWords;
    }
}


