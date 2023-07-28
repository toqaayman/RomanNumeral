/**
 * Abstract class representing a list of Roman numerals.
 */
public abstract class RomanNumeralList {
    protected RomanNumeralListNode head;
    protected int size;
    /**
     * Constructor for the list, initializes an empty list with a dummy node as head.
     */
    public RomanNumeralList() {
        this.head = new RomanNumeralListNode(null);
        this.size = 0;
    }
    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }
    /**
     * Checks whether the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    /**
     * Adds a Roman numeral to the list in a specific order.
     *
     * @param numeral the Roman numeral to add
     */
    public abstract void add(RomanNumeral numeral);
    /**
     * Returns the Roman numeral at a specific index in the list.
     *
     * @param index the index of the Roman numeral to get
     * @return the Roman numeral at the specified index
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public RomanNumeral get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        RomanNumeralListNode curr = head.getNext();
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        return curr.getData();
    }
}
