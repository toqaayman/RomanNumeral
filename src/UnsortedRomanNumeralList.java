/**

A class that represents a list of Roman numerals in unsorted order.
Extends the RomanNumeralList abstract class.

*/
public class UnsortedRomanNumeralList extends RomanNumeralList {
	/**

	Adds a RomanNumeral to the end of the list.
	@param numeral the RomanNumeral to add
	*/
	
	@Override
    public void add(RomanNumeral numeral) {
        RomanNumeralListNode newNode = new RomanNumeralListNode(numeral);
        RomanNumeralListNode curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(newNode);
        size++;
    }
	/**

	Appends a RomanNumeral to the end of the list.
	@param numeral the RomanNumeral to append
	*/
    public void append(RomanNumeral numeral) {
        add(numeral);
    }
}
