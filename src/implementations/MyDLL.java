package implementations;

import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.ListADT;

public class MyDLL<E> implements ListADT<E>{
	
	private MyDLLNode head;
	private MyDLLNode tail;
	private int size;
	
	/**
	 * Node class
	 * 
	 * Stores pointers to previous and next element, as well as the object
	 */
	private class MyDLLNode {
		private MyDLLNode next;
		private MyDLLNode prev;
		private E item;
		
		public MyDLLNode(E data) {
			this.item = data;
		}
	}
	
	/**
	 * Iterator for the class
	 * Iterator object stores a pointer (current) that is used to go through items in the array
	 */
	private class MyIterator implements Iterator<E> {
		
		private MyDLLNode current;
		
		/**
		 * @return if current is not the last item, returns true
		 */
		@Override
		public boolean hasNext() {
			return !(current.equals(tail)) ;
		}
		
		
		/**
		 * returns the items of each node sequentially
		 * @return on the first call returns the first item, on each following call returns the next item
		 * @throws NoSuchElementException if trying to iterate beyond the last item
		 */
		@Override
		public E next() throws NoSuchElementException {
			if (hasNext()) {
				MyDLLNode  element = current;
				current = current.next;
				return element.item;
			}
			else {
				throw new NoSuchElementException();
			}
		}
		
		public MyIterator() {
			this.current = head;
		}
	}

	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
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
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
