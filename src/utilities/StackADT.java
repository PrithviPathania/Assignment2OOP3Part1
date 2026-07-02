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
    
    
    // Person 2 (Gavin)
    
    /**
     * Checks if this stack is equal to another stack.
     *
     * Pre-condition: The stack being compared should not be null.
     * Post-condition: Neither stack is changed.
     *
     * @param that the stack to compare to
     * @return true if the stacks contain the same elements, otherwise false
     */
    boolean equals(StackADT<E> that);

    /**
     * Creates an iterator for the stack.
     *
     * Pre-condition: None.
     * Post-condition: The stack is not modified.
     *
     * @return an iterator for the stack
     */
    Iterator<E> iterator();

    /**
     * Copies the stack elements into an Object array.
     *
     * Pre-condition: None.
     * Post-condition: The stack remains unchanged.
     *
     * @return an array containing the stack elements
     */
    Object[] toArray();

    /**
     * Copies the stack elements into the specified array.
     *
     * Pre-condition: The array cannot be null.
     * Post-condition: The stack remains unchanged.
     *
     * @param copy array to store the elements
     * @return the array containing the stack elements
     * @throws NullPointerException if the array is null
     */
    E[] toArray(E[] copy);

    /**
     * Searches for an element in the stack.
     *
     * Pre-condition: None.
     * Post-condition: The stack remains unchanged.
     *
     * @param obj the element to search for
     * @return the position of the element, or -1 if not found
     */
    int search(E obj);

    /**
     * Checks if the stack contains a specific element.
     *
     * Pre-condition: None.
     * Post-condition: The stack remains unchanged.
     *
     * @param obj the element to look for
     * @return true if the element exists in the stack, otherwise false
     */
    boolean contains(E obj);

    /**
     * Gets the number of elements in the stack.
     *
     * Pre-condition: None.
     * Post-condition: The stack remains unchanged.
     *
     * @return the number of elements in the stack
     */
    int size();

    /**
     * Checks if the stack is empty.
     *
     * Pre-condition: None.
     * Post-condition: The stack remains unchanged.
     *
     * @return true if the stack contains no elements, otherwise false
     */
    boolean isEmpty();

    /**
     * Removes all elements from the stack.
     *
     * Pre-condition: None.
     * Post-condition: The stack becomes empty.
     */
    void clear();
}