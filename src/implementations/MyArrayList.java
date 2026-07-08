package implementations;
/*
 * You will be penalized 50% of your final mark for the assignment if you use the java classes
   from the java.util.*, or similar packages for the implementations of MyStack, MyQueue,
   MyArrayList and MyDLL.
   The exception is using the Arrays.copyOf() or System.arraycopy() methods to resize your array
   in MyArrayList, the toArray methods and the Iterator implementations. You are also allowed to
   use any of the standard exceptions in the Java library such as NullPointerException and
   NoSuchElementException

 */
import java.util.NoSuchElementException;

import utilities.Iterator;
import utilities.ListADT;

/**
 * Implementation of the Array List class. Stores data in a array
 * @param <E> the type variable
 * @author Deema 
 * @version 1
 */
public class MyArrayList<E> implements ListADT<E> {
	
	private E[] storage;
	private int size = 0;
	
	/**
	 * Iterator for the class
	 * Iterator object stores a pointer (index) that is used to go through items in the array
	 */
	private class MyIterator implements Iterator<E> {
		
		private int index;
		
		/**
		 * @return if index does not point to the last item, returns true
		 */
		@Override
		public boolean hasNext() {
			return index < size;
		}
		
		
		/**
		 * @return on the first call returns the first item, on each following call returns the next item
		 * @throws NoSuchElementException if trying to iterate beyond the last item
		 */
		@Override
		public E next() throws NoSuchElementException {
			if (hasNext()) {
				E element = storage[index];
				index++;
				return element;
			}
			else {
				throw new NoSuchElementException();
			}
		}
		
		public MyIterator() {
			this.index = 0;
		}
	}

	/**
	 * @return the number of items in the array
	 */
	@Override
	public int size() {
		return this.size;
	}

	
	/**
	 * empties the array. 
	 */
	@Override
	public void clear() {
		for (int i = 0; i < size; i++ ) {
			this.storage[i] = null;
		}
		this.size = 0;
	}

	
	/**
	 * add an item at specific index. shift existing item at the index and any following items to the right
	 * @return true if successful
	 * @throws NullPointerException if trying to add a null item. IndexOutOfBoundsException if index is out of the scope of the array
	 * @param index the index to which we insert, toAdd is the item
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		
		
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			if (index == size) {
				add(toAdd);
				
				return true;
			}
			else {
				//increase the capacity
				E[] storageExpanded = (E[]) new Object[storage.length + 1];
				for (int i = 0; i < size; i++) {
			        storageExpanded[i] = storage[i];
			    }
				storage = storageExpanded;
				
				//shift
				
				for (int i = size; i > index; i--) {
					storage[i] = storage[i - 1]; 
				}
				
				//insert
				storage[index] = toAdd;
				size++;
				return true;
				
			}
		}
	}

	
	/**
	 * appends an item to the array. Expands the capacity if full
	 * @return true if successful
	 * @param toAdd is the item we are appending
	 * @throws NullPointerException if trying to add a null item
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		else {
			//if full
			if (size == storage.length) {
				E[] storageExpanded = (E[]) new Object[storage.length + 1];
				for (int i = 0; i < size; i++) {
			        storageExpanded[i] = storage[i];
			    }
				storage = storageExpanded;
				
			
			}
			storage[size] = toAdd;
			size++;
			return true;
		}
	}

	
	/**
	 * adds an array
	 * @return true if successful
	 * @throws NullPointerException if trying to add a null item
	 * @param toAdd array of items for type E of its children
	 */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if (toAdd == null) {
			throw new NullPointerException();
		}
		else {
			utilities.Iterator<? extends E> it = toAdd.iterator();
			while (it.hasNext()) {
				add(it.next());
				
			}
		return true;
		}
	}

	/**
	 * gets the item at passed index
	 * @param index the index at which the item we are reaching is
	 * @return the item stored at the index or null
	 * @throws IndexOutOfBoundsException if reaching outside scope
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			return storage[index];
		}
	}

	
	/**
	 * remove an item from array. works by shifting every item after the index 1 step to the left.
	 * @param index the index of the item we are trying to remove
	 * @return the removed item
	 * @throws IndexOutOfBoundsException if reaching out of scope
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		
		
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
	    E removed = this.storage[index];
	    //shifts everything 1 to left over the item at index
	    for (int i = index; i < size - 1; i++) {
	        storage[i] = storage[i + 1];
	    }
	    
	    
	    storage[size - 1] = null;
	    size--;
	    return removed;
	}
	
	/**
	 * Removes the first occurrence of the passed object, if any
	 * @return the item we removed or null
	 * @throws NullPointerException if toRemove is null
	 * @param toRemove the object we are looking for, to remove it
	 * 
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		
		if (toRemove == null) { 
			throw new NullPointerException();
		}
		
		for (int i = 0; i < size; i++) {
			if (storage[i].equals(toRemove)) {
				return remove(i);
			}
		}
		return null;
	}
	
	
	/**
	 * overwrites the value at index
	 * @param index the index of the item, toChange the object that will be at the index 
	 * @return the item that used to be there before
	 * @throws NullPointerException if trying to set a null item. IndexOutOfBoundsException if index is out of the scope of the array
	 */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		
		
		if (toChange == null) {
			throw new NullPointerException();
		}
		else if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		
		E prev = storage[index];
		storage[index] = toChange;
		return prev;
		
	}
	
	
	/**
	 * Checks if array is empty
	 * @return true if empty
	 */
	@Override
	public boolean isEmpty() {
		if (size <= 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * checks if array contains an object
	 * @param toFind the object we are searching for
	 * @return true if found
	 * @throws  NullPointerException if trying to search for a null item
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
			throw new NullPointerException();
		}
		utilities.Iterator<E> it = this.iterator();
		
		while (it.hasNext()) {
			if (it.next().equals(toFind)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Translates to an array of type E that we pass in
	 * @return the array that now contains the data from storage
	 * @param toHold is the array we put data in
	 * @throws  NullPointerException if the passed array is null 
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		
		if (toHold == null) {
			throw new NullPointerException();
		}
		
		if (toHold.length < size) {
		    toHold = (E[]) java.lang.reflect.Array.newInstance(toHold.getClass().getComponentType(), size);
		}
		
		for (int i = 0; i < size; i++) {
		        toHold[i] = storage[i];
		}
		
		return toHold;
	}
	
	
	/**
	 * returns a new array with the data from storage
	 * @return Object []
	 */
	@Override
	public Object[] toArray() {
		return (Object[]) storage;
	}
	
	/**
	 * creates an iterator for the object
	 */
	@Override
	public Iterator<E> iterator() {
		return new MyIterator();
	}

	/**
	 * constructor with set storage capacity
	 * @param capacity the capacity of the underlying storage
	 */
	@SuppressWarnings("unchecked")
	public MyArrayList(int capacity) {
		
		this.storage = (E[]) new Object[capacity];
		this.size = 0;
	}
	
	/**
	 * constructor with null capacity
	 * @param capacity the capacity of the underlying storage
	 */
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		
		this.storage = (E[]) new Object[0];
		this.size = 0;
	}
	
	
	
}
