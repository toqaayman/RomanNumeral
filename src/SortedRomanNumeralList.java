/**
Represents a sorted list of Roman numeral objects.
*/
public class SortedRomanNumeralList extends RomanNumeralList {
	/**

	Inserts the given Roman numeral object into the sorted list in its correct position.

	@param numeral the Roman numeral object to be added
	*/
	@Override
    public void add(RomanNumeral numeral) {
        RomanNumeralListNode newNode = new RomanNumeralListNode(numeral);
        RomanNumeralListNode prev = head;
        RomanNumeralListNode curr = head.getNext();
     // Traverse the list until we reach the correct position to insert the new node

        while (curr != null && curr.getData().compareTo(numeral) < 0) {
            prev = curr;
            curr = curr.getNext();
        }
     // Insert the new node into the list

        newNode.setNext(curr);
        prev.setNext(newNode);
        size++;
    }
}

