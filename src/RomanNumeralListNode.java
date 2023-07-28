/**
Represents a node in a linked list of Roman numerals.
*/
public class RomanNumeralListNode {
    private RomanNumeral data; // The Roman numeral data held by the node
    private RomanNumeralListNode next; // The next node in the linked list
    /**
    Constructs a new node with the given Roman numeral data.
    @param data the Roman numeral data to be held by the node
    */
    public RomanNumeralListNode(RomanNumeral data) {
        this.data = data;
        this.next = null;
    }
    /**

    Returns the Roman numeral data held by the node.
    @return the Roman numeral data held by the node
    */
    public RomanNumeral getData() {
        return data;
    }
    /**

    Sets the Roman numeral data held by the node.
    @param data the Roman numeral data to be set for the node
    */
    public void setData(RomanNumeral data) {
        this.data = data;
    }
    /**

    Returns the next node in the linked list.
    @return the next node in the linked list
    */
    public RomanNumeralListNode getNext() {
        return next;
    }
    /**

    Sets the next node in the linked list.
    @param next the next node in the linked list to be set
    */
    public void setNext(RomanNumeralListNode next) {
        this.next = next;
    }
}
