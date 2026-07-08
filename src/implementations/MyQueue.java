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

	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dequeueAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int search(E toFind) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(QueueADT<E> that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
