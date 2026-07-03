package implementations;

import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.ListADT;


/**
 * @author Deema
 * @version 0.1
 * @param <E> type of the items stored in the DLL
 */
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
				MyDLLNode element = current;
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

	/**
	 * @return number of items in the list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * clears the list. Sets the references to null and size to 0
	 */
	@Override
	public void clear() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	
	/**
	 * inserts an item at a specified position
	 * 
	 * @return true if successful
	 * @param index the position at which item must be inserted, toAdd is the object we are inserting
	 * @throws  NullPointerException if trying to insert a null item. IndexOutOfBoundsException if index is out of the scope of the list
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
				
				if (toAdd == null) {
					throw new NullPointerException();
				}
				if (index >= size || index < 0) {
					throw new IndexOutOfBoundsException();
				}
		
				//empty
				if (head == null) {
					add(toAdd);
				}
				//only one item
				else if (head != null && tail == head) {
					add(toAdd);
				}
				//any other case (now the indexes actually matter)
				else {
					
					MyDLLNode nodePointer = head;
					for (int i = 0; i <= index; i++) {
						if (i == index) {
							//at this moment the nodePointer points to the node at index. 
							MyDLLNode toInsert = new MyDLLNode(toAdd);
							
							toInsert.prev = nodePointer.prev;
							toInsert.next = nodePointer;
							nodePointer.prev = toInsert;
							
							size++;
							
							return true;
						}
						else {
							nodePointer = nodePointer.next;
						}
					}
				}
				
				return false;
		
	}

	
	/**
	 * append an item
	 * @param the item
	 * @return true if successful
	 * @throws  NullPointerException if trying to append a null item
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException {
				//empty
				if (head == null) {
					head = new MyDLLNode(toAdd);
					tail = new MyDLLNode(toAdd);
					size++;
					return true;
				}
				//only one item
				else if (head != null && tail == head) {
					
					tail = new MyDLLNode(toAdd);
					head.next = tail;
					tail.prev = head;
					size++;
					
					return true;
				}
				//any other case 
				else {
					MyDLLNode nodeToAdd = new MyDLLNode(toAdd);
	
					nodeToAdd.prev = tail;
					tail.next = nodeToAdd;
					tail = nodeToAdd;

					size++;
					
					return true;
				}
	}

	
	/**
	 * add a list of items
	 * @return true if successful
	 * @param the list of items we add
	 * @throws NullPointerException if toAdd is null
	 */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		
		
		utilities.Iterator<E> it = this.iterator();
		
		while (it.hasNext()) {
			add(it.next());
			
		}
		return true;
	}

	
	/**
	 * gets the item at index
	 * @param index index
	 * @throws IndexOutOfBoundsException if index is out of the scope of the list
	 * @return the item at that position
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		MyDLLNode nodePointer = head;
		for (int i = 0; i <= index; i++) {
			if (i == index) {
				return nodePointer.item;
			}
			else {
				nodePointer = nodePointer.next;
			}
		}
		return null;
	}
	
	
	/**
	 * removes a node at index
	 * 
	 * @return the removed node's item
	 * @throws IndexOutOfBoundsException if index is out of the scope of the list
	 * @param index index
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		MyDLLNode nodePointer = head;
		for (int i = 0; i <= index; i++) {
			if (i == index) {
				
				MyDLLNode removed = nodePointer;
				
				nodePointer.prev.prev.next = nodePointer;
				nodePointer.prev = nodePointer.prev.prev;
				
				size--;
				
				return removed.item;
			}
			else {
				nodePointer = nodePointer.next;
			}
		}
		return null;
	}

	
	/**
	 * removes the first occurrence of specified item
	 * 
	 * @return the removed item or null if not found
	 * @param toRemove is the item to remove
	 * @throws  NullPointerException if trying to remove a null item
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove == null) {
			throw new NullPointerException();
		}
		
		
		MyDLLNode nodePointer = head;
		
		if (nodePointer.item.equals(toRemove)) {
			MyDLLNode removed = nodePointer;
			
			nodePointer.prev.prev.next = nodePointer;
			nodePointer.prev = nodePointer.prev.prev;
			
			size--;
			
			return removed.item;
		}
		else {
			nodePointer = nodePointer.next;
		}
		return null;
	}

	
	
	/**
	 * overwrites an item at index
	 * @return item that used to be there
	 * @param index index, toChange item
	 * @throws  NullPointerException if trying to set a null item. IndexOutOfBoundsException if index is out of the scope of the list
	 */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (toChange == null) {
			throw new NullPointerException();
		}
		
		MyDLLNode nodePointer = head;
		for (int i = 0; i <= index; i++) {
			if (i == index) {
				
				MyDLLNode overwriten = nodePointer;
				
				nodePointer.item = toChange;
				
				return overwriten.item;
			}
			else {
				nodePointer = nodePointer.next;
			}
		}
		return null;
	}

	
	/**
	 * checks if list is empty
	 * @return true if empty
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	
	/**
	 * searches for an item in the list
	 * @return true if found
	 * @param toFind item
	 * @throws  NullPointerException if looking for a null item. 
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}
		MyDLLNode nodePointer = head;
		if (nodePointer.item.equals(toFind)) {
				
				return true;
			}
			else {
				nodePointer = nodePointer.next;
			}
		return false;
	}

	
	/**
	 * adds the items to a specified array of type E
	 * @return the array that now contains the data from our list
	 * @param toHold is the array we put data in
	 * @throws  NullPointerException if the passed array is null 
	 * 
	 */
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold == null) {
			throw new NullPointerException();
		}
		
		if (toHold.length < size) {
			@SuppressWarnings("unchecked")
			E[] bigEnough = (E[]) new Object[size];
			toHold = bigEnough;
		}
		MyDLLNode nodePointer = head;
		for (int i = 0; i < size; i++) {
		        toHold[i] = nodePointer.item;
		        nodePointer = nodePointer.next;
		}
		
		return toHold;
	}

	
	/**
	 * returns a new array with the data from the list
	 * @return Object []
	 */
	@Override
	public Object[] toArray() {
		Object [] arr = new Object[size];
		MyDLLNode nodePointer = head;
		for (int i = 0; i < this.size; i++) {
	        arr[i] = nodePointer.item;
	        nodePointer = nodePointer.next;
	}
		return arr;
	}
	
	
	/**
	 * creates the iterator for an object
	 * @return iterator object
	 */
	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}
	
	/**
	 * standard constructor
	 */
	public MyDLL() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
}
