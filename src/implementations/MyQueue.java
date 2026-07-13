package implementations;

import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;

/*
 * You will be penalized 50% of your final mark for the assignment if you use the java classes
   from the java.util.*, or similar packages for the implementations of MyStack, MyQueue,
   MyArrayList and MyDLL.
   The exception is using the Arrays.copyOf() or System.arraycopy() methods to resize your array
   in MyArrayList, the toArray methods and the Iterator implementations. You are also allowed to
   use any of the standard exceptions in the Java library such as NullPointerException and
   NoSuchElementException
   
   
   	Write an implementation for the utility class MyQueue.java using the QueueADT.java and
	Iterator.java interfaces and EmptyQueueException.java provided by your instructor. Use
	your MyDLL.java implementation as the underlying data structure to store the elements of
	the queue.

 */

public class MyQueue<E> implements QueueADT<E> {
	//structure to store the elements of the stack

	MyDLL<E> list;
	/**
	 * Initializes an empty queue.
	 */
	public MyQueue() {
	    this.list = new MyDLL<>();
	}
	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException("Cannot enqueue a null element.");
		}
		list.add(toAdd);
		
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException("Cannot dequeue from an empty queue.");
		}
		return list.remove(0);
	}

	@Override
	public E peek() throws EmptyQueueException {
		
		if (isEmpty()) {
			throw new EmptyQueueException("Cannot peek from an empty queue.");
		}
		return list.get(0);
	}

	@Override
	public void dequeueAll() {

		list.clear();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		
		if (toFind == null) {
			throw new NullPointerException("Cannot search for a null element.");
		}
		return list.contains(toFind);
	}

	@Override
	public int search(E toFind) {
		for (int i = 0; i < list.size(); i++) {
	        if (list.get(i).equals(toFind)) {
	            return i + 1; // 1-based position (index 0 is search 1)
	        }
	    }
	    return -1; // Not found
	}

	@Override
	public Iterator<E> iterator() {
		 return list.iterator();
	}

	@Override
	public boolean equals(QueueADT<E> secondQueue) {
		Iterator<E> FirstQueue = this.iterator();
		Iterator<E> SecondQueue = secondQueue.iterator();
		//while both queues have elements (ensures same size), compare them one by one 
		while (FirstQueue.hasNext() && SecondQueue.hasNext()) {
			E FirstQueueElement = FirstQueue.next();
			E secondQueueElement = SecondQueue.next();
			if (!FirstQueueElement.equals(secondQueueElement)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if (holder == null) {
			throw new NullPointerException("The provided array is null.");
		}
		return list.toArray(holder);
	}

	@Override
	public boolean isFull() {
		// its not fixed size so it can never be full
		return false;
	}

	@Override
	public int size() {
		return list.size();
	}

}
