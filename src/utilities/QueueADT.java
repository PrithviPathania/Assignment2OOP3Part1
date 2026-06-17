package utilities;
//linked list
public interface QueueADT {
	
	//v will be replaced with the real value queue holds 

	/**
	 * create empty queue (default constructor)
	 */
	
	
	/**
	 * add to the end of the queue (enqueue)
	 * precondition: the value to be added must not be null, and the queue must not be full.
	 * postcondition: the value is added to the end of the queue, and the size of the queue is increased by one. the size of the queue after the value is added to the end of the queue is returned. 
	 * @param value the value to be added to the end of the queue
	 * @return the size of the queue after the value is added to the end of the queue
	 * @throws NullPointerException if the value to be added is null
	 * @
	 */
	int enqueue() throws NullPointerException, IllegalStateException;
	
	/**
	 * remove from the front of the queue (dequeue)
	 * precondition: a queue must exist and must not be empty.
	 * postcondition: the value at the front of the queue is removed from the queue, and the size of the queue is decreased by one. the size of the queue after the value is removed from the front of the queue is returned.
	 * @return the size of the queue after the value is removed from the front of the queue
	 * 
	 */
	
	int dequeue();
	
	/**
	 * look up the first value within the queue (the one at the very front of the queue) (Peek)
	 * precondition: a queue must exist and must not be empty.
	 * postcondition: returns the value at the front of the queue without removing it from the queue.
	 * @return the value at the front of the queue
	 */
	V peek();
}
