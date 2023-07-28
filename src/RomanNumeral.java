public class RomanNumeral implements Comparable<RomanNumeral> {
    private String romanNumeral;// The Roman numeral as a string
    private int arabicValue;// The Arabic numeral equivalent

    public RomanNumeral(String romanNumeral) {// Constructor takes a Roman numeral as input
        this.romanNumeral = romanNumeral;
        this.arabicValue = convertToArabic(romanNumeral);// Convert to Arabic numeral and store it
        if (!romanNumeral.matches("[MDCLXVI]+")) {
            throw new IllegalRomanNumeralException("Invalid Roman numeral: " + romanNumeral);
        }
    }

    public String getRomanNumeral() {// Getter method for Roman numeral string
        return romanNumeral;
    }

    public void setRomanNumeral(String romanNumeral) {// Setter method for Roman numeral string
        this.romanNumeral = romanNumeral;
        this.arabicValue = convertToArabic(romanNumeral);// Convert to Arabic numeral and update stored value
    }

    public int getArabicValue() {// Getter method for Arabic numeral value
        return arabicValue;
    }

    private int convertToArabic(String romanNumeral) {// Private helper method to convert Roman numeral to Arabic numeral
        int result = 0;
        int lastValue = 0;

        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            char c = romanNumeral.charAt(i);
            int currentValue = getValue(c);

            if (currentValue < lastValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            lastValue = currentValue;// Store current value for next iteration
        }

        return result;
    }

    private int getValue(char c) {// Private helper method to get value of Roman numeral character
        switch (c) { // Use switch statement to map each character to its corresponding value
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public boolean equals(RomanNumeral other) {// Method to check equality of two Roman numerals
        return this.arabicValue == other.arabicValue;
    }

    public int compareTo(RomanNumeral other) {// Method to compare two Roman numerals
        return this.arabicValue - other.arabicValue;
    }

    public String toString() {// Method to convert Roman numeral object to string
        return this.romanNumeral;
    }
}

