package implementations;

import java.util.EmptyStackException;

import utilities.Iterator;
import utilities.StackADT;

/*
 * You will be penalized 50% of your final mark for the assignment if you use the java classes
   from the java.util.*, or similar packages for the implementations of MyStack, MyQueue,
   MyArrayList and MyDLL.
   The exception is using the Arrays.copyOf() or System.arraycopy() methods to resize your array
   in MyArrayList, the toArray methods and the Iterator implementations. You are also allowed to
   use any of the standard exceptions in the Java library such as NullPointerException and
   NoSuchElementException

 */
/*
 *  Write an implementation for the utility class MyStack.java using the StackADT.java and
	Iterator.java interfaces provided by your instructor. Use your MyArrayList.java
	implementation as the underlying data structure to store the elements of the stack.
 */
public class MyStack<E> implements StackADT<E> {

	@Override
	public void push(E toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E pop() throws EmptyStackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() throws EmptyStackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
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
	public boolean equals(StackADT<E> that) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean stackOverflow() {
		// TODO Auto-generated method stub
		return false;
	}

}
