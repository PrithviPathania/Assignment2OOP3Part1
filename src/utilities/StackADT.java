package utilities;

import java.util.*;

//array list
/*
 *  appropriate pre-conditions, post-conditions,
	parameters, return values and expected exceptions using proper Javadoc notations
 */
public interface StackADT<E> {
 
	
	// Person 1 (Prithvi)
	
	/**
     * The ability to add to the top of a stack
     * Precondition: the value to be added must not be null, and the stack must not be full.
     * Postcondition: the value is added to the top of the stack, and the size of the stack is increased by one. 
     * @param value the value to be added to the top of the stack
     * @throws NullPointerException if the value to be added is null
     * @throws IllegalStateException if the stack is full
     * 
     *
     */
    void push(E value) throws NullPointerException, IllegalStateException;
    /**
     * The ability to remove the element from the top of the stack
     * Precondition: the stack must not be empty.
     * Postcondition: the element at the top of the stack is removed, and the size of the stack is decreased by one. The element that was removed from the top of the stack is returned.
     * @return the element that was removed from the top of the stack
     * @throws EmptyStackException if the stack is empty
     *
     *
     *
     */
    
    E pop() throws EmptyStackException;

    /**
     * The ability to look up the first value within the stack (the one at the very top of the stack)
     * Precondition: Stack must not be empty.
     * Postcondition: The element at the top of the stack is returned and the stack remains unchanged.
     * @return returns value at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    E peek() throws EmptyStackException;
    
    
    // Person 2 ()
	boolean equals(StackADT<E> that);

    Iterator<E> iterator();
    
    Object[] toArray();

    E[] toArray(E[] copy);

    int search(E obj);

    boolean contains(E obj);

    int size();

    boolean isEmpty();

    void clear();



}
