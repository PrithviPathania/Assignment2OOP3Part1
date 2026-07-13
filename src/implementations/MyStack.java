package implementations;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

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
	//structure to store the elements of the stack
	private MyArrayList<E> list;
	/**
     * Initializes an empty stack.
     */
    public MyStack() {
        this.list = new MyArrayList<>();
    }
    
    
    
	@Override
	public void push(E toAdd) throws NullPointerException {
		if (toAdd == null) {
            throw new NullPointerException("Cannot push a null element onto the stack.");
        }
        // Add to the end of the list (top of the stack)
        list.add(toAdd);		
	}

	@Override
	public E pop() throws EmptyStackException {
		if (isEmpty()) {
            throw new EmptyStackException();
        }
        // Remove and return the last item in the list
        return list.remove(list.size() - 1);
	}

	@Override
	public E peek() throws EmptyStackException {
		if (isEmpty()) {
            throw new EmptyStackException();
        }
        // View the last item in the list without removing it
        return list.get(list.size() - 1);
	}

	@Override
	public void clear() {
		list.clear();		
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	//needs to be reversed because the stack is LIFO and the list is FIFO
	public Object[] toArray() {
		Object[] original = list.toArray();
	    Object[] reversed = new Object[original.length];
	    
	    // Start i at the last index of the original array and count down to 0
	    int index = 0;
	    //  original - 1 so we don't get the out of bounds exception because array starts at index 0 but length is the amount of items not where they are so it needs to subtract 1 (basically length starts at 1)
	    
	    for (int i = original.length - 1; i >= 0; i--) {
	    	// Fill the reversed array starting from index 0  ( copies last item in original to first item in reversed and so on)
	        reversed[index] = original[i];
	        index++;
	    }
	    
	    return reversed;
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if (holder == null) {
            throw new NullPointerException("The provided array cannot be null.");
        }
		E[] original = list.toArray(holder);
        
		int left = 0;
		//  original - 1 so we don't get the out of bounds exception because array starts at index 0 but length is the amount of items not where they are so it needs to subtract 1 (basically length starts at 1)
		int right = original.length - 1;
		
		
		while (left < right) {
			//swap
		    E temp = original[left];
		    original[left] = original[right];
		    original[right] = temp;
		    
		    // move the pointers towards one another
		    left++;
		    right--;
		}
		
		return original;
		}        
	
	

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if (toFind == null) {
            throw new NullPointerException("Search target cannot be null.");
        }
        return list.contains(toFind);
}

	@Override
	public int search(E toFind) {
		
        // Start searching from the top of the stack and move down to the bottom
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).equals(toFind)) {
                return list.size() - i; 
            }
        }
        return -1; // Not found
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>()
		 {
            private final Object[] copy = list.toArray();
            //start at the last index of the copy array to iterate from top of stack to bottom
            private int index = copy.length - 1;
            @Override
            public boolean hasNext() {
            	return index >= 0;
            }

            @SuppressWarnings("unchecked")
			@Override
            public E next() throws NoSuchElementException {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (E) copy[index--];
            }
        };
	}

	@Override
	public boolean equals(StackADT<E> secondStack) {
		
		Iterator<E> FirstStack = this.iterator();
		Iterator<E> SecondStack = secondStack.iterator();
		while (FirstStack.hasNext() && SecondStack.hasNext()) {
			E firstStackElement = FirstStack.next();
			E secondStackElement = SecondStack.next();
			if (!firstStackElement.equals(secondStackElement)) {
				return false;
			}
		}
		return true;
		
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean stackOverflow() {
		// Since MyArrayList resizes dynamically, the stack won't overflow ( when the array gets full it just creates a new bigger array with all the same elements)
		return false;
	}

}
