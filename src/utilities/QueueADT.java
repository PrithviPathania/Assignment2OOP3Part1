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
    // Person 4 

    Object[] toArray();
  
    E[] toArray(E[] copy);

    boolean isFull();

    int size();

    boolean isEmpty();

    void dequeueAll();
}
