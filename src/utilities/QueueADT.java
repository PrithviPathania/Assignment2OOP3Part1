package utilities;
//linked list

/**
 * 
 * Interface for the queue data type
 * 
 * @author Deema 
 * @version 1
 * @param <E> default type
 */
public interface QueueADT<E> {

	// Person 3 (Deema)

	/**
	 * Adds an item to the queue. 
	 * @param element the element to enqueue
	 */
    void enqueue(E element);

    /**
     * pops the top item of the queue
     * @return the dequeued item
     */
    E dequeue();

    /**
     * returns the top item without removing it from the queue
     * @return the top item
     */
    E peek();

    /**
     * checks if this queue equals to that. 
     * @param that the queue we compare to
     * @return true if same
     */
    boolean equals(QueueADT<E> that);

    /**
     * creates an iterator object for a given queue object
     * @return iterator object
     */
    Iterator<E> iterator();
	
    // Person 4 (Valentina)

    /**
     * returns an array containing all the items in the queue
     * @return array with the elements of the queue
     */
    Object[] toArray();

    /**
     * returns an array containing all the items in the queue
     * @param copy array used to store the elements
     * @return array with the elements of the queue
     */
    E[] toArray(E[] copy);

    /**
     * checks if the queue is full
     * @return true if the queue is full
     */
    boolean isFull();

    /**
     * returns the number of items in the queue
     * @return the size of the queue
     */
    int size();

    /**
     * checks if the queue is empty
     * @return true if the queue has no items
     */
    boolean isEmpty();

    /**
     * removes all items from the queue
     */
    void dequeueAll();
}
